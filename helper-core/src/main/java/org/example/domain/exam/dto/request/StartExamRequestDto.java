package org.example.domain.exam.dto.request;

import java.time.LocalDate;
import java.util.List;

public record StartExamRequestDto(
        LocalDate deadline,
        LocalDate start,
        LocalDate end,
        List<MajorGradeRequestDto> grades
) { }