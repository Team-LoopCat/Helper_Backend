package org.example.domain.post.model;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.model.Category;

@Getter
@Builder
@RequiredArgsConstructor
public class Post {

    private final UUID postId;

    private final String studentId;

    private final String title;

    private final String content;

    private final Optional<String> photo;

    private final String tag;

    private final PostCategory category;

    private final LocalDateTime createdAt;
}
