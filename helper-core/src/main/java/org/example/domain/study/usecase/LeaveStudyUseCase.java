package org.example.domain.study.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.study.model.Member;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CommandMemberService;
import org.example.domain.study.service.GetMemberService;
import org.example.domain.study.service.GetStudyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LeaveStudyUseCase {
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final GetStudyService getStudyService;
    private final GetMemberService getMemberService;
    private final CommandMemberService commandMemberService;

    public void execute(UUID studyId) {
        Study currentStudy = getStudyService.getStudyById(studyId);
        Student currentStudent = getStudentService.getStudentByUser(securityService.getCurrentUser());

        Member member = getMemberService.getByStudyAndStudent(currentStudy, currentStudent);

        commandMemberService.deleteMember(member);
    }
}
