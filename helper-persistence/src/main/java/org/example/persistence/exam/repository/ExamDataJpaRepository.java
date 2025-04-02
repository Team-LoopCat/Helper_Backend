package org.example.persistence.exam.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.domain.exam.spi.vo.SimpleExamDataVO;
import org.example.persistence.exam.entity.ExamDataJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ExamDataJpaRepository extends JpaRepository<ExamDataJpaEntity, UUID> {

    @Query(
            "SELECT ed.exam " +
            "FROM examData ed " +
            "ORDER BY ed.date DESC " +
            "LIMIT 1")
    Optional<ExamDataJpaEntity> findFirstByOrderByDateDesc();

    @Query(
            "SELECT new org.example.domain.exam.spi.vo.SimpleExamDataVO(ed.examDataId, s.name, t.name, ed.date, ed.period, ed.problems, ed.percent) " +
            "FROM examData ed " +
            "INNER JOIN subject s ON s.subjectId = ed.subject.subjectId " +
            "INNER JOIN teach teach ON teach.subject.subjectId = s.subjectId " +
            "INNER JOIN teacher t ON t.teacherId = teach.teacher.teacherId " +
            "ORDER BY ed.date, ed.period"
    )
    List<SimpleExamDataVO> findAllSimpleExamDataByExamDataId(@Param("examDataId") UUID examDataId);

    Boolean existsByDateAndPeriod(LocalDate date, Integer period);
}
