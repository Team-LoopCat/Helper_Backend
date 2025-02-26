package org.example.domain.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.test.exception.TestNotFoundException;
import org.example.domain.test.model.Test;
import org.example.domain.test.service.GetTestService;
import org.example.domain.test.spi.QueryTestPort;
import org.example.domain.test.spi.vo.TestListDataForStudentVO;
import org.example.domain.test.spi.vo.TestListForTeacherDataVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTestServiceImpl implements GetTestService {
    private final QueryTestPort queryTestPort;

    @Override
    public Test getTestById(UUID testId) {
        return queryTestPort.getTestById(testId).orElseThrow(
                () -> TestNotFoundException.EXCEPTION
        );
    }

    @Override
    public List<TestListForTeacherDataVO> getTestListDataForTeacherBySubjectId(UUID subjectId) {
        return queryTestPort.getTestListDataForTeacherBySubjectId(subjectId);
    }

    @Override
    public List<TestListDataForStudentVO> getTestDataListForStudentByGradeAndClassroom(String grade, String classroom) {
        return queryTestPort.getTestDataListForStudentByGradeAndClassroom(grade, classroom);
    }

    @Override
    public TestListDataForStudentVO getTestDataForStudentBySubjectId(UUID subjectId) {
        return queryTestPort.getTestDataForStudentBySubjectId(subjectId);
    }
}
