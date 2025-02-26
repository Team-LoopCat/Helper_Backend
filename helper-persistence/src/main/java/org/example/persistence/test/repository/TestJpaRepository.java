package org.example.persistence.test.repository;

import java.util.List;
import java.util.UUID;

import org.example.domain.test.spi.vo.TestListDataForStudentVO;
import org.example.domain.test.spi.vo.TestListForTeacherDataVO;
import org.example.persistence.test.entity.TestJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TestJpaRepository extends CrudRepository<TestJpaEntity, UUID> {

    @Query("SELECT " +
        "new org.example.domain.test.spi.vo.TestListForTeacherDataVO(t.testId, t.title, t.subject.name, MIN(ti.endDate), MAX(ti.endDate)) " +
        "FROM test t INNER JOIN testInfo ti ON t.testId = ti.test.testId " +
        "WHERE t.subject.subjectId = :subjectId " +
        "GROUP BY t.testId, t.title, t.content")
    List<TestListForTeacherDataVO> findTestListDataForTeacherBySubjectId(@Param("subjectId") UUID subjectId);

    @Query("SELECT " +
        "new org.example.domain.test.spi.vo.TestListDataForStudentVO(t.testId, t.title, s.name, ti.endDate) " +
        "FROM attend a INNER JOIN testInfo ti ON (a.attendId = ti.attend.attendId) " +
            "INNER JOIN test t ON (ti.test.testId = t.testId) " +
            "INNER JOIN subject s ON (a.subject.subjectId = s.subjectId and s.optional = false) " +
        "WHERE a.gradeInfo.grade = :grade " +
            "AND a.gradeInfo.classroom = :classroom")
    List<TestListDataForStudentVO> findStudentTestListDataByGradeAndClassroom(@Param("grade") String grade, @Param("classroom") String classroom);

    @Query("SELECT " +
        "new org.example.domain.test.spi.vo.TestListDataForStudentVO(t.testId, t.title, s.name, ti.endDate) " +
        "FROM attend a INNER JOIN testInfo ti ON (a.attendId = ti.attend.attendId) " +
            "INNER JOIN test t ON (ti.test.testId = t.testId) " +
            "INNER JOIN subject s ON (a.subject.subjectId = s.subjectId and s.subjectId = :subjectId)"
    )
    TestListDataForStudentVO findTestDataForStudentBySubjectId(@Param("subjectId") UUID subjectId);
}
