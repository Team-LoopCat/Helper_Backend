package org.example.persistence.study.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;
import org.example.persistence.study.entity.StudyJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudyJpaRepository extends CrudRepository<StudyJpaEntity, UUID> {

    @Query(value =
            "SELECT s.study_id, s.student_id, s.subject_id, s.title, s.content, s.location, s.date, s.start, s.end, s.category, count(m.study_id) " +
            "FROM study s " +
            "JOIN member m " +
            "ON s.study_id = m.study_id && m.is_banned = 0 " +
            "WHERE s.subject_id = :subjectId " +
            "GROUP BY s.study_id " +
            "ORDER BY s.date, s.start",
            nativeQuery = true)
    List<StudyWithMemberCountVO> findAllBySubjectSubjectIdWithCount(@Param("subjectId") UUID subjectId);

    @Query(value =
            "SELECT s.study_id, s.student_id, s.subject_id, s.title, s.content, s.location, s.date, s.start, s.end, s.category, count(m.study_id) " +
            "FROM study s " +
            "JOIN member m " +
            "ON s.study_id = m.study_id && m.is_banned = 0 " +
            "WHERE s.study_id = :studyId ",
            nativeQuery = true
    )
    Optional<StudyWithMemberCountVO> findDetailByStudyId(@Param("studyId") UUID studyId);
}
