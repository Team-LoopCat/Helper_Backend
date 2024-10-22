package org.example.persistence.post.repository;

import java.util.UUID;
import org.example.persistence.post.entity.ReplyJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReplyJpaRepository extends CrudRepository<ReplyJpaEntity, UUID> {

}
