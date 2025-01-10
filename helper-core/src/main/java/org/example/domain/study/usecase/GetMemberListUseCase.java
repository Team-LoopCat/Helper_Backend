package org.example.domain.study.usecase;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.study.dto.response.GetMemberListResponseDto;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CheckStudyService;
import org.example.domain.study.service.GetMemberService;
import org.example.domain.study.service.GetStudyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetMemberListUseCase {
    private final GetStudyService getStudyService;
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final CheckStudyService checkStudyService;
    private final GetMemberService getMemberService;

    public GetMemberListResponseDto execute(UUID studyId) {
        Study currentStudy = getStudyService.getStudyById(studyId);
        Student currentStudent = getStudentService.getStudentByUser(securityService.getCurrentUser());

        checkStudyService.checkStudyIsOwn(currentStudy, currentStudent);

        List<Student> members = getMemberService.getAllStudentByStudy(currentStudy);

        return GetMemberListResponseDto.from(members);
    }
}
