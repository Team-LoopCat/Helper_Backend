package org.example.domain.comment.spi;

import org.example.domain.comment.model.Comment;

import java.util.Optional;
import java.util.UUID;

public interface QueryCommentPort {

    void saveComment(Comment comment);

    void deleteComment(Comment comment);

    Optional<Comment> getCommentByCommentId(UUID commentId);

    boolean checkComemntById(UUID commentId);
}
