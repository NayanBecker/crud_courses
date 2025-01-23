package com.courses.api.crud_courses.modules.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.courses.api.crud_courses.modules.Entities.CoursesEntity;
import com.courses.api.crud_courses.modules.dto.UpdateCourseDTO;
import com.courses.api.crud_courses.modules.useCases.CreateCourseUseCase;
import com.courses.api.crud_courses.modules.useCases.DeleteCourseUseCase;
import com.courses.api.crud_courses.modules.useCases.ListCoursesUseCase;
import com.courses.api.crud_courses.modules.useCases.ToggleCourseStatusUseCase;
import com.courses.api.crud_courses.modules.useCases.UpdateCourseUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListCoursesUseCase listCoursesUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;
    
    @Autowired
    private ToggleCourseStatusUseCase toggleCourseStatusUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CoursesEntity coursesEntity) {
        try {
            var result = this.createCourseUseCase.execute(coursesEntity);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> list(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {
        try {
            var courses = this.listCoursesUseCase.execute(name, category);
            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody UpdateCourseDTO updateCourseDTO) {
        try {
            var upadatedCourse = updateCourseUseCase.execute(id, updateCourseDTO);
            return ResponseEntity.ok(upadatedCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteCourseUseCase.execute(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> toggleActiveStatus(@PathVariable UUID id) {
        try {
            var updatedCourse = toggleCourseStatusUseCase.execute(id);
            return ResponseEntity.ok(updatedCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
