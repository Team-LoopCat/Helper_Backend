package org.example.domain.test.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.service.GetSubjectService;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.service.GetTeacherService;
import org.example.domain.test.dto.response.GetTeacherTestListResponseDto;
import org.example.domain.test.service.GetTestService;
import org.example.domain.test.spi.vo.TestListForTeacherDataVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetTestListForTeacherUseCase {
    private final GetTeacherService getTeacherService;
    private final GetTestService getTestService;
    private final GetSubjectService getSubjectService;

    public GetTeacherTestListResponseDto execute() {
        Teacher teacher = getTeacherService.getCurrentTeacher();
        List<Subject> subjects = getSubjectService.getSubjectsByTeacher(teacher.getTeacherId());

        List<TestListForTeacherDataVO> testListData = new ArrayList<>();
        for (Subject subject: subjects) {
            List<TestListForTeacherDataVO> testData = getTestService.getTestListDataForTeacherBySubjectId(subject.getSubjectId());
            testListData.addAll(testData);
        }

        return new GetTeacherTestListResponseDto(testListData);
    }
}
