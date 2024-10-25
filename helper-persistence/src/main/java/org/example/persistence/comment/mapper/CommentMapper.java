package org.example.persistence.comment.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.Comment;
import org.example.persistence.GenericMapper;
import org.example.persistence.comment.entity.CommentJpaEntity;
import org.example.persistence.post.entity.PostJpaEntity;
import org.example.persistence.post.repository.PostJpaRepository;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.example.persistence.student.repository.StudentJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper implements GenericMapper<Comment, CommentJpaEntity> {
    private final StudentJpaRepository studentJpaRepository;
    private final PostJpaRepository postJpaRepository;

    @Override
    public Optional<Comment> toDomain(Optional<CommentJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        CommentJpaEntity commentEntity = entity.get();

        return Optional.of(new Comment(
                commentEntity.getCommentId(),
                commentEntity.getStudent().getStudentId(),
                commentEntity.getPost().getPostId(),
                commentEntity.getContent(),
                commentEntity.getCreatedAt()
        ));
    }

    @Override
    public CommentJpaEntity toEntity(Comment entity) {
        StudentJpaEntity studentJpaEntity = studentJpaRepository.findByStudentId
                (entity.getStudentId()).orElse(null);

        PostJpaEntity postJpaEntity = postJpaRepository.findById
                (entity.getPostId()).orElse(null);

        return new CommentJpaEntity(
                entity.getCommentId(),
                studentJpaEntity,
                postJpaEntity,
                entity.getContent(),
                entity.getCreatedAt()
        );
    }
}
