package org.example.persistence.comment.repository;

import java.util.UUID;
import org.example.persistence.comment.entity.ReplyJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReplyJpaRepository extends CrudRepository<ReplyJpaEntity, UUID> {

}
