package org.example.domain.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.exception.CommentNotExistsException;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.comment.spi.QueryCommentPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCommentServiceImpl implements GetCommentService {
    private final QueryCommentPort queryCommentPort;

    @Override
    public Comment getCommentByCommentId(UUID commentId) {
        return queryCommentPort.getCommentByCommentId(commentId).orElseThrow(
                () -> CommentNotExistsException.EXCEPTION
        );
    }
}
