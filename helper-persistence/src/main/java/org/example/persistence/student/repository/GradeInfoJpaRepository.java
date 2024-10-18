package org.example.persistence.student.repository;

import java.util.Optional;
import org.example.persistence.student.entity.GradeInfoId;
import org.example.persistence.student.entity.GradeInfoJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface GradeInfoJpaRepository extends CrudRepository<GradeInfoJpaEntity, GradeInfoId> {

    Optional<GradeInfoJpaEntity> findByClassroomAndGrade(String classroom, String grade);
}
