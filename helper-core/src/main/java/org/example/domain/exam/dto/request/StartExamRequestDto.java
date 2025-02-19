package org.example.domain.exam.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record StartExamRequestDto(
        @NotNull @Valid List<MajorExamDataRequestDto> exams
) { }