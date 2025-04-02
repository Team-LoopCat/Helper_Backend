package org.example.persistence.test.repository;

import java.util.List;
import java.util.UUID;

import org.example.domain.test.spi.vo.TestDetailVO;
import org.example.domain.test.spi.vo.TestListDataForStudentVO;
import org.example.domain.test.spi.vo.TestListDataForTeacherVO;
import org.example.persistence.test.entity.TestJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TestJpaRepository extends CrudRepository<TestJpaEntity, UUID> {

    @Query("SELECT " +
        "new org.example.domain.test.spi.vo.TestListDataForTeacherVO(t.testId, t.title, s.name, MIN(ti.endDate), MAX(ti.endDate)) " +
        "FROM test t INNER JOIN testInfo ti ON t.testId = ti.test.testId " +
            "INNER JOIN attend a ON a.attendId = ti.attend.attendId " +
            "INNER JOIN subject s ON s.subjectId = a.subject.subjectId " +
        "WHERE s.subjectId = :subjectId " +
        "GROUP BY t.testId, t.title, t.content")
    List<TestListDataForTeacherVO> findTestListDataForTeacherBySubjectId(@Param("subjectId") UUID subjectId);

    @Query(value = "SELECT " +
            "new org.example.domain.test.spi.vo.TestListDataForStudentVO(t.testId, t.title, a.subject.name, ti.endDate) " +
            "FROM attend a INNER JOIN testInfo ti ON a.attendId = ti.attend.attendId " +
                "INNER JOIN test t ON ti.test.testId = t.testId " +
                "INNER JOIN subject s ON a.subject.subjectId = s.subjectId " +
            "WHERE s.optional = false " +
                "AND a.gradeInfo.grade = :grade " +
                "AND a.gradeInfo.classroom = :classroom")
    List<TestListDataForStudentVO> findStudentTestListDataByGradeAndClassroom(@Param("grade") String grade, @Param("classroom") String classroom);

    @Query(value = "SELECT " +
            "new org.example.domain.test.spi.vo.TestListDataForStudentVO(t.testId, t.title, s.name, ti.endDate) " +
            "FROM attend a INNER JOIN testInfo ti ON (a.attendId = ti.attend.attendId) " +
            "INNER JOIN test t ON (ti.test.testId = t.testId) " +
            "INNER JOIN subject s ON (a.subject.subjectId = s.subjectId and s.subjectId = :subjectId)")
    TestListDataForStudentVO findTestDataForStudentBySubjectId(@Param("subjectId") UUID subjectId);

    @Query(value = "SELECT " +
            "new org.example.domain.test.spi.vo.TestDetailVO(t.testId, s.subjectId, t.title, s.name, t.content, t.percent) " +
            "FROM test t INNER JOIN testInfo ti ON t.testId = ti.test.testId " +
                "INNER JOIN attend a ON a.attendId = ti.attend.attendId " +
                "INNER JOIN subject s ON s.subjectId = a.subject.subjectId " +
            "WHERE t.testId = :testId")
    TestDetailVO findTestDetailById(@Param("testId") UUID testId);
}
