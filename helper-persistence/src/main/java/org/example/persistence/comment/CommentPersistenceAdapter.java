package org.example.persistence.comment;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.spi.QueryCommentPort;
import org.example.persistence.comment.mapper.CommentMapper;
import org.example.persistence.comment.repository.CommentJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CommentPersistenceAdapter implements QueryCommentPort {
    private final CommentJpaRepository commentJpaRepository;
    private final CommentMapper commentMapper;

    @Override
    public void saveComment(Comment comment) {
        commentJpaRepository.save(
                commentMapper.toEntity(comment)
        );
    }

    @Override
    public void deleteComment(Comment comment) {
        commentJpaRepository.delete(
                commentMapper.toEntity(comment)
        );
    }

    @Override
    public Optional<Comment> getCommentByCommentId(UUID commentId) {
        return commentMapper.toDomain(
                commentJpaRepository.findByCommentId(commentId)
        );
    }

    @Override
    public boolean checkComemntById(UUID commentId) {
        return commentJpaRepository.existsByCommentId(commentId);
    }
}
