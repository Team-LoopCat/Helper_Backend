package org.example.domain.comment.spi.vo;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReplyDataVO (
        UUID replyId,
        String studentId,
        String writerName,
        String contents,
        LocalDateTime createdAt
) {
}
