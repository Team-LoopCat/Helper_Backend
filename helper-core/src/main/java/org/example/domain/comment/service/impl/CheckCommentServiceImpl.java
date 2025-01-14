package org.example.domain.comment.service.impl;

import org.example.domain.comment.execption.IsNotOwnerOfCommentException;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.CheckCommentService;
import org.springframework.stereotype.Service;

@Service
public class CheckCommentServiceImpl implements CheckCommentService {

    @Override
    public void checkIsOwner(Comment comment, String studentId) {
        if (!comment.getStudentId().equals(studentId)) {
            throw IsNotOwnerOfCommentException.EXCEPTION;
        }
    }
}
