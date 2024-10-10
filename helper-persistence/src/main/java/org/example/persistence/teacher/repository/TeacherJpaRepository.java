package org.example.persistence.teacher.repository;

import org.example.persistence.teacher.entity.TeacherJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface TeacherJpaRepository extends CrudRepository<TeacherJpaEntity, UUID> {

    Optional<TeacherJpaEntity> findByTeacherId(UUID teacherId);
}
