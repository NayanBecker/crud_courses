package com.courses.api.crud_courses.modules.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.api.crud_courses.modules.Entities.CoursesEntity;
import com.courses.api.crud_courses.modules.repositories.CoursesRepository;

@Service
public class ToggleCourseStatusUseCase {
    
    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesEntity execute(UUID id){
        var course = coursesRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setStatus(course.getStatus() == CoursesEntity.CourseStatus.ACTIVE ? CoursesEntity.CourseStatus.INACTIVE : CoursesEntity.CourseStatus.ACTIVE);

        return coursesRepository.save(course);
    }
}
