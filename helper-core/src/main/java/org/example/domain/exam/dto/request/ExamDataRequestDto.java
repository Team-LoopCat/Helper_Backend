package org.example.domain.exam.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public record ExamDataRequestDto(
        @NotNull UUID subjectId,
        @NotNull LocalDate date,
        @NotNull Integer period
) { }
