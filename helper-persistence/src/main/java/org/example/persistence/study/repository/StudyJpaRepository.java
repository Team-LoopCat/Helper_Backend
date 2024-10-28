package org.example.persistence.study.repository;

import java.util.UUID;
import org.example.persistence.study.entity.StudyJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudyJpaRepository extends CrudRepository<StudyJpaEntity, UUID> {

}
