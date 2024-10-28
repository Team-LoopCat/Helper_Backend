package org.example.persistence.gradeInfo.repository;

import org.example.persistence.student.entity.GradeInfoId;
import org.example.persistence.student.entity.GradeInfoJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GradeInfoJpaRepository extends CrudRepository<GradeInfoJpaEntity, GradeInfoId> {

    Optional<GradeInfoJpaEntity> findByClassroomAndGrade(String classroom, String grade);

    Boolean existsByGradeAndClassroom(String grade, String classroom);
}
