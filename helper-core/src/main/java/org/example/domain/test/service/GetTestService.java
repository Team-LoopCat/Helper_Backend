package org.example.domain.test.service;

import org.example.domain.test.model.Test;
import org.example.domain.test.spi.vo.TestListDataForStudentVO;
import org.example.domain.test.spi.vo.TestListForTeacherDataVO;

import java.util.List;
import java.util.UUID;

public interface GetTestService {

    Test getTestById(UUID testId);

    List<TestListForTeacherDataVO> getTestListDataForTeacherBySubjectId(UUID subjectId);
}
