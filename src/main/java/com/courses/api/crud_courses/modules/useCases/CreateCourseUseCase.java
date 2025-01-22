package com.courses.api.crud_courses.modules.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.api.crud_courses.exceptions.UserFoundException;
import com.courses.api.crud_courses.modules.Entities.CoursesEntity;
import com.courses.api.crud_courses.modules.repositories.CoursesRepository;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesEntity execute(CoursesEntity coursesEntity){

        this.coursesRepository
            .findById(coursesEntity.getId())
            .ifPresent((user) -> {
                throw new UserFoundException("Course already exists");
            });
            return this.coursesRepository.save(coursesEntity);
    }
}
