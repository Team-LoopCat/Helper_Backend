package org.example.domain.comment.service;

import org.example.domain.comment.model.Comment;

import java.util.UUID;

public interface CheckCommentService {

    void checkIsOwner(Comment comment, String studentId);

    void checkCommentExistsByCommentId(UUID commentId);
}
