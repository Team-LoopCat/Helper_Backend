package org.example.persistence.post.repository;

import java.util.UUID;
import org.example.persistence.post.entity.PostJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostJpaRepository extends CrudRepository<PostJpaEntity, UUID> {

}
