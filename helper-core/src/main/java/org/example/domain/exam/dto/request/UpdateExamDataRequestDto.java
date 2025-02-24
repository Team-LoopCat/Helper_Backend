package org.example.domain.exam.dto.request;

import java.util.UUID;

public record UpdateExamDataRequestDto(
        UUID subjectId
) { }
