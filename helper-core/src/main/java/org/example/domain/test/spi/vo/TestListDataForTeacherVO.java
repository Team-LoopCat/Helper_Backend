package org.example.domain.test.spi.vo;

import java.time.LocalDate;
import java.util.UUID;

public record TestListDataForTeacherVO(
        UUID testId,
        String title,
        String subject,
        LocalDate minDate,
        LocalDate maxDate
) {
}
