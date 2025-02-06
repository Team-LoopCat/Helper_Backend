package org.example.persistence.exam.repository;

import java.util.UUID;
import org.example.persistence.exam.entity.ExamJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExamJpaRepository extends CrudRepository<ExamJpaEntity, UUID> {

    boolean existsByGrade(String grade);
}
