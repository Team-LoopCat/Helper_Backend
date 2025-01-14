package org.example.domain.student.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record SignupRequestDto(
        @NotBlank String grade,
        @NotBlank String classroom,
        @NotBlank String number,
        @NotBlank String id,
        @NotBlank String nickname,
        @NotBlank String password,
        @NotBlank String email,
        @Nullable String profile
) {}
