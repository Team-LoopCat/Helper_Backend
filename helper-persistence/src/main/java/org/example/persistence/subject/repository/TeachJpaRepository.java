package org.example.persistence.subject.repository;

import org.example.persistence.subject.entity.TeachId;
import org.example.persistence.subject.entity.TeachJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeachJpaRepository extends CrudRepository<TeachJpaEntity, TeachId> {

}
