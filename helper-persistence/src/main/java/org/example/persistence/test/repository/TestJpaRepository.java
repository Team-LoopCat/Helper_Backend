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
}
