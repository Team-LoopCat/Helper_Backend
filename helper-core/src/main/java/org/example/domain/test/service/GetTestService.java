package org.example.domain.test.service;

import org.example.domain.test.model.Test;
import org.example.domain.test.spi.vo.TestListDataForStudentVO;
import org.example.domain.test.spi.vo.TestListDataForTeacherVO;

import java.util.List;
import java.util.UUID;

public interface GetTestService {

    Test getTestById(UUID testId);

    List<TestListDataForTeacherVO> getTestListDataForTeacherBySubjectId(UUID subjectId);

    List<TestListDataForStudentVO> getTestDataListForStudentByGradeAndClassroom(String grade, String classroom);

    TestListDataForStudentVO getTestDataForStudentBySubjectId(UUID subjectId);
}
