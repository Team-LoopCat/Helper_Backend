package org.example.domain.exam.dto.request;

import org.example.domain.student.model.Major;

public record MajorGradeRequestDto(
        Major major,
        String grade
) { }