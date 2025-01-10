package org.example.domain.study.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.study.model.Member;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CheckStudyService;
import org.example.domain.study.service.CommandMemberService;
import org.example.domain.study.service.GetMemberService;
import org.example.domain.study.service.GetStudyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyBanStudentsUseCase {
    private final GetStudyService getStudyService;
    private final GetStudentService getStudentService;
    private final GetMemberService getMemberService;
    private final CommandMemberService commandMemberService;
    private final CheckStudyService checkStudyService;
    private final SecurityService securityService;

    public void execute(UUID studyId, String studentId) {
        Study currentStudy = getStudyService.getStudyById(studyId);
        Student banStudent = getStudentService.getStudentByStudentId(studentId);

        // member 존재 여부 확인
        getMemberService.getByStudyAndStudent(currentStudy, banStudent);

        Student currentStudent = getStudentService.getStudentByUser(securityService.getCurrentUser());
        checkStudyService.checkStudyIsOwn(currentStudy, currentStudent);

        commandMemberService.saveMember(
                Member.builder()
                        .studyId(studyId)
                        .studentId(studentId)
                        .isBanned(true)
                        .build()
        );
    }
}
