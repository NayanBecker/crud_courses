package com.courses.api.crud_courses.modules.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.courses.api.crud_courses.modules.Entities.CoursesEntity;
import com.courses.api.crud_courses.modules.useCases.CreateCourseUseCase;
import com.courses.api.crud_courses.modules.useCases.ListCoursesUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private ListCoursesUseCase listCoursesUseCase;

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
}
