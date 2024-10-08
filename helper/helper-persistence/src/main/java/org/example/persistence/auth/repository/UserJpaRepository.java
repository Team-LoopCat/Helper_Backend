package org.example.persistence.auth.repository;

import org.example.persistence.auth.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserJpaRepository extends CrudRepository<UserJpaEntity, String> {
    Optional<UserJpaEntity> findByUserId(String userId);
}
