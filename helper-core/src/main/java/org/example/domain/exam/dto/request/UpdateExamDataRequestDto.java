package org.example.domain.exam.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record UpdateExamDataRequestDto(
        @NotNull UUID subjectId
) { }
