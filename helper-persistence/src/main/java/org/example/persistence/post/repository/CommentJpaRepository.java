package org.example.persistence.post.repository;

import java.util.UUID;
import org.example.persistence.post.entity.CommentJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentJpaRepository extends CrudRepository<CommentJpaEntity, UUID> {

}
