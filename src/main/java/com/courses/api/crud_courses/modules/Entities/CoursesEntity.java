package com.courses.api.crud_courses.modules.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "courses")
public class CoursesEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    private String name;
    private String category;

    @CreationTimestamp
    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;
    private CourseStatus status;


    public enum CourseStatus {
        ACTIVE,
        INACTIVE,
        COMPLETED
    }
}
