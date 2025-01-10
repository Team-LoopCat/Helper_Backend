package org.example.persistence.comment;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.spi.QueryCommentPort;
import org.example.persistence.comment.mapper.CommentMapper;
import org.example.persistence.comment.repository.CommentJpaRepository;
import org.springframework.stereotype.Component;

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
}
