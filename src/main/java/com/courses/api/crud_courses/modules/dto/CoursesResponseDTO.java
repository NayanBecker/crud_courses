package com.courses.api.crud_courses.modules.dto;

import java.util.UUID;

import com.courses.api.crud_courses.modules.Entities.CoursesEntity.CourseStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoursesResponseDTO {
    private String name;
    private String category;
    private String description;
    private CourseStatus status;
    private UUID id;
}
