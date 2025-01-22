package com.courses.api.crud_courses.modules.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.api.crud_courses.exceptions.UserFoundException;
import com.courses.api.crud_courses.modules.dto.CoursesResponseDTO;
import com.courses.api.crud_courses.modules.repositories.CoursesRepository;

@Service
public class ProfileCourseUseCase {
    
    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesResponseDTO execute(UUID idCourse){
        var course = this.coursesRepository.findById(idCourse)
        .orElseThrow(() -> {
            throw new UserFoundException("Course not found");
        });
        var courseDTO = CoursesResponseDTO.builder()
            .description(course.getDescription())
            .name(course.getName())
            .category(course.getCategory())
            .status(course.getStatus())
            .id(course.getId())
            .build();
            
            return courseDTO;
    }
}
