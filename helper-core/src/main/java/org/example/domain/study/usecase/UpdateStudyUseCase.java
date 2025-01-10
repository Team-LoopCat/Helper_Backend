package org.example.domain.study.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.study.dto.request.UpdateStudyRequestDto;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CheckStudyService;
import org.example.domain.study.service.CommandStudyService;
import org.example.domain.study.service.GetStudyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateStudyUseCase {
    private final CommandStudyService commandStudyService;
    private final GetStudyService getStudyService;
    private final GetStudentService getStudentService;
    private final CheckStudyService checkStudyService;
    private final SecurityService securityService;

    public void execute(UUID studyId, UpdateStudyRequestDto request) {
        Study currentStudy = getStudyService.getStudyById(studyId);
        Student currentStudent = getStudentService.getStudentByUserId(securityService.getCurrentUser());

        checkStudyService.checkStudyIsOwn(currentStudy, currentStudent);

        commandStudyService.saveStudy(
                Study.builder()
                        .studyId(currentStudy.getStudyId())
                        .studentId(currentStudy.getStudentId())
                        .title(request.title())
                        .content(request.content())
                        .location(request.location())
                        .date(request.date())
                        .start(request.start())
                        .end(request.end())
                        .category(request.category())
                        .build()
        );
    }
}
