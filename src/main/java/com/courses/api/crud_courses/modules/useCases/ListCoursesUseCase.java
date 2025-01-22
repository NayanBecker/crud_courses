package com.courses.api.crud_courses.modules.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.api.crud_courses.modules.Entities.CoursesEntity;
import com.courses.api.crud_courses.modules.repositories.CoursesRepository;

@Service
public class ListCoursesUseCase {
    
    @Autowired
    private CoursesRepository coursesRepository;

    public  List<CoursesEntity> execute(String name, String category) {
        if (name != null && category != null) {
            return  coursesRepository.findByNameContainingAndCategoryContaining(name, category);
        } else if (name != null) {
            return  coursesRepository.findByNameContaining(name);
        } else if (category != null) {
            return  coursesRepository.findByCategoryContaining(category);
        }
            return coursesRepository.findAll();
    }
}
