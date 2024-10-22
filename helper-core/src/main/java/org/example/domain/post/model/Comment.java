package org.example.domain.post.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Comment {

    private final UUID commentId;

    private final String studentId;

    private final UUID postId;

    private final String content;

    private final LocalDateTime createdAt;
}
