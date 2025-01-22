package com.courses.api.crud_courses.modules.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courses.api.crud_courses.modules.Entities.CoursesEntity;

@Repository
public interface CoursesRepository extends JpaRepository<CoursesEntity, UUID> {

    Optional<CoursesEntity> findByName(String name);
    List<CoursesEntity> findByNameContaining(String name);
    List<CoursesEntity> findByCategoryContaining(String category);
    List<CoursesEntity> findByNameContainingAndCategoryContaining(String name, String category);
}
