package org.example.persistence.teacher.repository;

import java.util.Optional;
import java.util.UUID;
import org.example.persistence.teacher.entity.TeacherJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeacherJpaRepository extends CrudRepository<TeacherJpaEntity, UUID> {

    Optional<TeacherJpaEntity> findByUserUserId(String id);

    Boolean existsTeacherJpaEntityByUserUserId(String id);
}
