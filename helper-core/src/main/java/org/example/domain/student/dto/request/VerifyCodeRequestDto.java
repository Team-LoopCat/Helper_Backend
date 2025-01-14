package org.example.domain.student.dto.request;

import jakarta.validation.constraints.NotBlank;

public record VerifyCodeRequestDto (
        @NotBlank String email,
        @NotBlank String code
) {
}
