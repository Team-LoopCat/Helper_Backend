package org.example.domain.comment.spi.vo;

import org.example.domain.comment.model.Comment;
import org.example.domain.student.model.Student;

import java.time.LocalDateTime;
import java.util.UUID;

public record CommentDataVO (
    UUID commentId,
    String studentId,
    String profile,
    String writerName,
    String contents,
    LocalDateTime createdAt
) { }
