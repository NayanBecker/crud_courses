package com.courses.api.crud_courses.modules.useCases;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.api.crud_courses.exceptions.UserFoundException;
import com.courses.api.crud_courses.modules.Entities.CoursesEntity;
import com.courses.api.crud_courses.modules.Entities.CoursesEntity.CourseStatus;
import com.courses.api.crud_courses.modules.repositories.CoursesRepository;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CoursesRepository coursesRepository;

    
    public CoursesEntity execute(UUID id) {
        var course = coursesRepository.findById(id)
                .orElseThrow(() -> {
                    throw new UserFoundException("Id dont exist");
                });

        course.setStatus(CourseStatus.INACTIVE);

        return this.coursesRepository.save(course);
    }
}