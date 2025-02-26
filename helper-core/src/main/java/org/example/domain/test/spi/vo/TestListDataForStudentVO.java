package org.example.domain.test.spi.vo;

import java.time.LocalDate;
import java.util.UUID;

public record TestListDataForStudentVO(
        UUID testId,
        String title,
        String subject,
        LocalDate endDate
) {
}
