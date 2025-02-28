package com.courses.api.crud_courses.modules.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.api.crud_courses.modules.Entities.CoursesEntity;
import com.courses.api.crud_courses.modules.repositories.CoursesRepository;

@Service
public class GetCourseDetailsUseCase {

    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesEntity execute(UUID id) {
        return coursesRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }
}
