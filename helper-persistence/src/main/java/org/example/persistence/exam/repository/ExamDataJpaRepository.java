package org.example.persistence.exam.repository;

import java.util.UUID;
import org.example.persistence.exam.entity.ExamDataJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExamDataJpaRepository extends CrudRepository<ExamDataJpaEntity, UUID> {

}
