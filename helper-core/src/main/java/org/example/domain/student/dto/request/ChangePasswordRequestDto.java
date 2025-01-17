package org.example.domain.student.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordRequestDto(
        @NotBlank String oldPassword,
        @NotBlank String password
) {}