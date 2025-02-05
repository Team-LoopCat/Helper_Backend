package org.example.persistence.exam.repository;

import java.util.UUID;
import org.example.persistence.exam.entity.ExamDataJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ExamDataJpaRepository extends JpaRepository<ExamDataJpaEntity, UUID> {

}
