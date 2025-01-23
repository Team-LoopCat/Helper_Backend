package org.example.domain.exam.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.domain.student.model.Major;

public record MajorGradeRequestDto(
        @NotNull Major major,
        @NotBlank String grade
) { }