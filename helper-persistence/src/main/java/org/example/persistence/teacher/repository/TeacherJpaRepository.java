package org.example.persistence.teacher.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.persistence.teacher.entity.TeacherJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeacherJpaRepository extends CrudRepository<TeacherJpaEntity, UUID> {

    Optional<TeacherJpaEntity> findByUserUserId(String id);

    Boolean existsTeacherJpaEntityByUserUserId(String id);

    @Query("SELECT t.name " +
            "FROM teacher t INNER JOIN teach tch ON t.teacherId = tch.teacher.teacherId " +
            "WHERE tch.subject.subjectId = :subjectId")
    List<String> getNamesBySubjectId(@Param("subjectId") UUID subjectId);
}
