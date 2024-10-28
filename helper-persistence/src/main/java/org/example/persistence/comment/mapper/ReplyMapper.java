package org.example.persistence.comment.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.Reply;
import org.example.persistence.GenericMapper;
import org.example.persistence.comment.entity.CommentJpaEntity;
import org.example.persistence.comment.entity.ReplyJpaEntity;
import org.example.persistence.comment.repository.CommentJpaRepository;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.example.persistence.student.repository.StudentJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReplyMapper implements GenericMapper<Reply, ReplyJpaEntity> {
    private final StudentJpaRepository studentJpaRepository;
    private final CommentJpaRepository commentJpaRepository;

    @Override
    public Optional<Reply> toDomain(Optional<ReplyJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        ReplyJpaEntity replyEntity = entity.get();

        return Optional.of(new Reply(
                replyEntity.getReplyId(),
                replyEntity.getComment().getCommentId(),
                replyEntity.getStudent().getStudentId(),
                replyEntity.getContent(),
                Optional.ofNullable(replyEntity.getMention()),
                replyEntity.getCreatedAt()
        ));
    }

    @Override
    public ReplyJpaEntity toEntity(Reply entity) {
        StudentJpaEntity studentJpaEntity = studentJpaRepository.findByStudentId
                (entity.getStudentId()).orElse(null);

        CommentJpaEntity commentJpaEntity = commentJpaRepository.findById
                (entity.getCommentId()).orElse(null);

        return new ReplyJpaEntity(
                entity.getReplyId(),
                studentJpaEntity,
                commentJpaEntity,
                entity.getContent(),
                entity.getMention().orElse(null),
                entity.getCreatedAt()
        );
    }
}
