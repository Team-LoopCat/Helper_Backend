package org.example.domain.study.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CheckStudyService;
import org.example.domain.study.service.CommandStudyService;
import org.example.domain.study.service.GetStudyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteStudyUseCase {
    private final CommandStudyService commandStudyService;
    private final GetStudyService getStudyService;
    private final GetStudentService getStudentService;
    private final CheckStudyService checkStudyService;
    private final SecurityService securityService;

    public void execute(UUID studyId) {
        Study currentStudy = getStudyService.getStudyById(studyId);
        Student currentStudent = getStudentService.getStudentByUserId(securityService.getCurrentUser());

        checkStudyService.checkStudyIsOwn(currentStudy, currentStudent);

        commandStudyService.deleteStudy(currentStudy);
    }
}
