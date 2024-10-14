package org.example.persistence.student.repository;

import org.example.persistence.student.entity.GradeInfoJpaEntity;
import org.example.persistence.student.entity.GradeInfoId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GradeInfoJpaRepository extends CrudRepository<GradeInfoJpaEntity, GradeInfoId> {

    Optional<GradeInfoJpaEntity> findByClassroomAndGrade(String classroom, String grade);
}
