package org.example.domain.study.usecase;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.study.dto.response.GetStudyListResponseDto;
import org.example.domain.study.service.GetStudyService;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetMyStudyListUseCase {
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final GetStudyService getStudyService;

    public GetStudyListResponseDto execute() {
        User user = securityService.getCurrentUser();

        Student currentStudent = getStudentService.getStudentByUserId(user);

        List<StudyWithMemberCountVO> myStudies = getStudyService.getStudyListByStudent(currentStudent);

        return GetStudyListResponseDto.from(myStudies);
    }
}
