package org.example.domain.comment.service;

import org.example.domain.comment.model.Comment;
import org.example.domain.comment.spi.vo.CommentDataVO;

import java.util.List;
import java.util.UUID;

public interface GetCommentService {
    Comment getCommentByCommentId(UUID commentId);

    List<CommentDataVO> getAllCommentsWithWritersByPost(UUID postId);
}
