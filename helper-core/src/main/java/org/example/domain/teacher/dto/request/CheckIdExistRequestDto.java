package org.example.domain.teacher.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CheckIdExistRequestDto(
        @NotBlank String id
) {
}
