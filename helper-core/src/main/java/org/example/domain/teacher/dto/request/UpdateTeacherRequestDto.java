package org.example.domain.teacher.dto.request;

public record UpdateTeacherRequestDto(
        String name,
        String id,
        String profile_image
) { }
