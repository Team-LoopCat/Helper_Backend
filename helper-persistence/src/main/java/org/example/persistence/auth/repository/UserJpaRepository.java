package org.example.persistence.auth.repository;

import java.util.Optional;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<UserJpaEntity, String> {

    Optional<UserJpaEntity> findByUserId(String userId);

    Boolean existsByUserId(String userId);

    void deleteByUserId(String userId);
}
