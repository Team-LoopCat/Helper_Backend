package org.example.persistence.exam.repository;

import java.util.List;
import java.util.UUID;
import org.example.persistence.exam.entity.ExamJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExamJpaRepository extends CrudRepository<ExamJpaEntity, UUID> {

    boolean existsBy();

    List<ExamJpaEntity> saveAll(List<ExamJpaEntity> e);
}
