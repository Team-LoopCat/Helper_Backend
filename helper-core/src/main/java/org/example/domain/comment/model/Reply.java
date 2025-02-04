package org.example.domain.comment.model;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Reply {

    private final UUID replyId;

    private final UUID commentId;

    private final String studentId;

    private final String content;

    private final Optional<String> mention;

    private final LocalDateTime createdAt;
}
