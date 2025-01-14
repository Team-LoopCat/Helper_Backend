package org.example.domain.comment.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Comment {

    private final UUID commentId;

    private final String studentId;

    private final UUID postId;

    private final String content;

    private final LocalDateTime createdAt;
}
