package org.example.domain.test.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.CheckGradeInfoService;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.test.dto.response.GetTestListForStudentResponseDto;
import org.example.domain.test.service.GetTestService;
import org.example.domain.test.spi.vo.TestListDataForStudentVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetTestListForStudentUseCase {
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final CheckGradeInfoService checkGradeInfoService;
    private final GetTestService getTestService;

    public GetTestListForStudentResponseDto execute() {
        Student student = getStudentService.getStudentByUser(securityService.getCurrentUser());
        checkGradeInfoService.checkGradeInfoNotExist(student.getGrade(), student.getClassroom());

        List<TestListDataForStudentVO> testListData = getTestService.getTestDataListForStudentByGradeAndClassroom(student.getGrade(), student.getClassroom());

        // 수강중인 선택과목 있다면 불러오기
        if (student.getSubjectId().isPresent()) {
            testListData.add(getTestService.getTestDataForStudentBySubjectId(student.getSubjectId().get()));
        }

        return GetTestListForStudentResponseDto.from(testListData);
    }
}
