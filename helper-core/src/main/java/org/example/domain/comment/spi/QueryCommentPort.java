package org.example.domain.comment.spi;

import org.example.domain.comment.model.Comment;
import org.example.domain.comment.spi.vo.CommentDataVO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QueryCommentPort {

    void saveComment(Comment comment);

    void deleteComment(Comment comment);

    Optional<Comment> getCommentByCommentId(UUID commentId);

    boolean checkComemntById(UUID commentId);
  
    List<CommentDataVO> getAllCommentsWithWritersByPost(UUID postId);
}
