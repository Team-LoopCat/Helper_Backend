package org.example.domain.test.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.service.CheckTeachService;
import org.example.domain.subject.service.GetSubjectService;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.service.GetTeacherService;
import org.example.domain.test.model.Test;
import org.example.domain.test.service.CommandTestService;
import org.example.domain.test.service.GetTestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteTestUseCase {
    private final GetTeacherService getTeacherService;
    private final GetTestService getTestService;
    private final GetSubjectService getSubjectService;
    private final CheckTeachService checkTeachService;
    private final CommandTestService commandTestService;

    public void execute(UUID testId) {
        Teacher teacher = getTeacherService.getCurrentTeacher();
        Test test = getTestService.getTestById(testId);
        Subject subject = getSubjectService.getSubjectById(test.getSubjectId());

        checkTeachService.checkTeacherTeachesSubject(teacher, subject);

        commandTestService.deleteTest(test);
    }
}
