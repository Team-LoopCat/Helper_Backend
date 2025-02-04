package org.example.domain.exam.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.example.domain.student.model.Major;

public record MajorExamDataRequestDto(
        @NotNull Major major,
        @NotNull @Valid List<ExamDataRequestDto> examData
) { }