package org.example.domain.teacher.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateTeacherRequestDto(
        @NotBlank String name,
        @NotBlank String id,
        @NotBlank String profile_image
) { }
