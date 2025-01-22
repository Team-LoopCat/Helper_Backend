package org.example.persistence.comment.repository;

import java.util.Optional;
import java.util.UUID;
import org.example.persistence.comment.entity.CommentJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentJpaRepository extends CrudRepository<CommentJpaEntity, UUID> {

    Optional<CommentJpaEntity> findByCommentId(UUID commentId);

    Boolean existsByCommentId(UUID commentId);
}
