package org.example.domain.student.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SendCodeRequestDto(
        @NotBlank String email
) { }