package org.example.persistence.subject.repository;ㅌ

import java.util.Optional;
import java.util.List;
import java.util.UUID;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectJpaRepository extends CrudRepository<SubjectJpaEntity, UUID> {

    @Query(value = "SELECT a.grade, a.classroom, s.name " +
            "FROM subject s " +
            "JOIN teach t " +
            "ON s.subject_id = t.subject_id " +
            "JOIN attend a " +
            "ON s.subject_id = a.subject_id " +
            "WHERE t.teacher_id = :teacherId",
            nativeQuery = true)
    List<SubjectAndAttendVO> findAllByTeachTeacherId(@Param("teacherId") UUID teacherId);
  
    Optional<SubjectJpaEntity> findBySubjectId(UUID id);
}
