package org.example.domain.test.spi.vo;

import java.util.UUID;

public record TestDetailVO (
        UUID id,
        UUID subjectId,
        String title,
        String subject,
        String content,
        Integer percent
) {
}
