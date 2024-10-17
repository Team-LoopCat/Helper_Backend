package org.example.persistence.gradeInfo.repository;

import org.example.persistence.gradeInfo.entity.GradeInfo;
import org.example.persistence.gradeInfo.entity.GradeInfoId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GradeInfoJpaRepository extends CrudRepository<GradeInfo, GradeInfoId> {

    Optional<GradeInfo> findByClassroomAndGrade(String classroom, String grade);

    Boolean existsByGradeAndClassroom(String grade, String classroom);
}
