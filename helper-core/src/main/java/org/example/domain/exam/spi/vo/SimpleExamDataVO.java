package org.example.domain.exam.spi.vo;

import java.time.LocalDate;
import java.util.UUID;

public record SimpleExamDataVO (
        UUID examDataId,
        String subject,
        String teacher,
        LocalDate date,
        Integer period,
        Integer problems,
        Integer percent
) {

}