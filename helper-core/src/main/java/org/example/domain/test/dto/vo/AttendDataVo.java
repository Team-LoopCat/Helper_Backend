package org.example.domain.test.dto.vo;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record AttendDataVo(
        @NotNull UUID attendId,
        @NotNull LocalDate endDate
) {
}
