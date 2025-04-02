package org.example.persistence.subject.repository;

import java.util.List;
import java.util.UUID;

import org.example.domain.subject.model.Attend;
import org.example.persistence.subject.entity.AttendJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AttendJpaRepository extends CrudRepository<AttendJpaEntity, UUID> {
    boolean existsByAttendId(UUID id);

    @Query("SELECT " +
            "new org.example.domain.subject.model.Attend(a.attendId, a.gradeInfo.grade, a.gradeInfo.classroom, a.subject.subjectId) " +
            "FROM test t INNER JOIN testInfo ti ON (t.testId = ti.test.testId AND t.testId = :testId) " +
                "INNER JOIN attend a ON ti.attend.attendId = a.attendId")
    List<Attend> getAttendsByTestId(@Param("testId") UUID testId);
}
