package com.courses.api.crud_courses.modules.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courses.api.crud_courses.modules.Entities.CoursesEntity;

public interface CoursesRepository extends JpaRepository<CoursesEntity, UUID> {
    
    Optional<CoursesEntity> findByName(String name);

    
}
