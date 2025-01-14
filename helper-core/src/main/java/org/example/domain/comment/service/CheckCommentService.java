package org.example.domain.comment.service;

import org.example.domain.comment.model.Comment;

public interface CheckCommentService {

    void checkIsOwner(Comment comment, String studentId);
}
