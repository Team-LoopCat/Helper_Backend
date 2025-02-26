package org.example.domain.test.spi;

import org.example.domain.test.model.Test;
import org.example.domain.test.spi.vo.TestListDataForStudentVO;
import org.example.domain.test.spi.vo.TestListForTeacherDataVO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QueryTestPort {

    Test saveTest(Test test);

    Optional<Test> getTestById(UUID testId);

    void deleteTest(Test test);

    List<TestListForTeacherDataVO> getTestListDataForTeacherBySubjectId(UUID subjectId);
}
