package org.example.domain.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.exception.CommentNotFoundException;
import org.example.domain.comment.exception.IsNotOwnerOfCommentException;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.CheckCommentService;
import org.example.domain.comment.spi.QueryCommentPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckCommentServiceImpl implements CheckCommentService {
    private final QueryCommentPort queryCommentPort;

    @Override
    public void checkIsOwner(Comment comment, String studentId) {
        if (!comment.getStudentId().equals(studentId)) {
            throw IsNotOwnerOfCommentException.EXCEPTION;
        }
    }

    @Override
    public void checkCommentExistsByCommentId(UUID commentId) {
        if (queryCommentPort.checkComemntById(commentId)) {
            throw CommentNotFoundException.EXCEPTION;
        }
    }
}
