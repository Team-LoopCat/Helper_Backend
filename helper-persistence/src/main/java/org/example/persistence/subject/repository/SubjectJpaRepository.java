package org.example.persistence.subject.repository;

import java.util.Optional;
import java.util.UUID;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectJpaRepository extends CrudRepository<SubjectJpaEntity, UUID> {

    Optional<SubjectJpaEntity> findBySubjectId(UUID id);
}
