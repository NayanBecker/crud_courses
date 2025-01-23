package com.courses.api.crud_courses.modules.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.api.crud_courses.exceptions.UserFoundException;
import com.courses.api.crud_courses.modules.Entities.CoursesEntity;
import com.courses.api.crud_courses.modules.dto.UpdateCourseDTO;
import com.courses.api.crud_courses.modules.repositories.CoursesRepository;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesEntity execute(UUID id, UpdateCourseDTO updateCourseDTO) {
        var course = coursesRepository.findById(id)
                .orElseThrow(() -> {
                    throw new UserFoundException("Id dont exist");
                });

        course.setName(updateCourseDTO.getName());
        course.setDescription(updateCourseDTO.getDescription());
        course.setCategory(updateCourseDTO.getCategory());

        return this.coursesRepository.save(course);
    }
}
