package org.example.persistence.student.repository;

import org.example.persistence.student.entity.GradeInfo;
import org.example.persistence.student.entity.GradeInfoId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GradeInfoJpaRepository extends CrudRepository<GradeInfo, GradeInfoId> {

    Optional<GradeInfo> findByClassroomAndGrade(String classroom, String grade);
}
