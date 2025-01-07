package org.example.domain.study.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.study.model.Member;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CheckMemberService;
import org.example.domain.study.service.CommandMemberService;
import org.example.domain.study.service.GetMemberService;
import org.example.domain.study.service.GetStudyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class JoinStudyUseCase {
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final GetStudyService getStudyService;
    private final CheckMemberService checkMemberService;
    private final CommandMemberService commandMemberService;
    private final GetMemberService getMemberService;

    public void execute(UUID studyId) {
        Student currentStudent = getStudentService.getStudentByUserId(securityService.getCurrentUser());

        Study currentStudy = getStudyService.getStudyById(studyId);
        
        Member member = getMemberService.getByStudyAndStudent(currentStudy, currentStudent);

        checkMemberService.checkAlreadyJoined(member);
        checkMemberService.checkBannedFromStudy(member);

        commandMemberService.saveMember(member);
    }
}
