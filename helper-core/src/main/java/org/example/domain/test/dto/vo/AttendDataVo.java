package org.example.domain.test.dto.vo;

import java.util.UUID;

public record AttendDataVo(
        UUID attendId,
        String endDate
) {
}
