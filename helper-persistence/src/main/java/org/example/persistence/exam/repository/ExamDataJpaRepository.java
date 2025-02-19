package org.example.persistence.exam.repository;

import java.util.Optional;
import java.util.UUID;
import org.example.persistence.exam.entity.ExamDataJpaEntity;
import org.example.persistence.exam.entity.ExamJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ExamDataJpaRepository extends JpaRepository<ExamDataJpaEntity, UUID> {

    @Query(
            "SELECT ed.exam " +
            "FROM examData ed " +
            "ORDER BY ed.date DESC " +
            "LIMIT 1")
    Optional<ExamDataJpaEntity> findFirstByOrderByDateDesc();
}
