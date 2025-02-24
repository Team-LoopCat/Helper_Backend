package org.example.domain.exam.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateExamDataDetailRequestDto(
        @NotNull Integer problems,
        @NotNull Integer percent,
        @NotBlank String content
) { }
