package org.example.domain.exam.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record StartExamRequestDto(
        @NotNull LocalDate deadline,
        @NotNull LocalDate start,
        @NotNull LocalDate end,
        @NotNull @Valid List<MajorGradeRequestDto> grades
) { }