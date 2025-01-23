package com.courses.api.crud_courses.modules.dto;

import lombok.Data;

@Data
public class UpdateCourseDTO {
    private String name;
    private String description;
    private String category;
}