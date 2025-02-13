package org.example.domain.test.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.file.model.File;
import org.example.domain.file.service.CommandFileService;
import org.example.domain.file.spi.vo.FileDataVO;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.service.CheckAttendService;
import org.example.domain.subject.service.CheckTeachService;
import org.example.domain.subject.service.GetSubjectService;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.service.GetTeacherService;
import org.example.domain.test.dto.request.UpdateTestRequestDto;
import org.example.domain.test.dto.vo.AttendDataVo;
import org.example.domain.test.model.Test;
import org.example.domain.test.model.TestInfo;
import org.example.domain.test.service.CommandTestInfoService;
import org.example.domain.test.service.CommandTestService;
import org.example.domain.test.service.GetTestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateTestUseCase {
    private final GetTeacherService getTeacherService;
    private final CheckTeachService checkTeachService;
    private final GetSubjectService getSubjectService;
    private final GetTestService getTestService;
    private final CommandTestService commandTestService;
    private final CheckAttendService checkAttendService;
    private final CommandTestInfoService commandTestInfoService;
    private final CommandFileService commandFileService;

    public void execute(UUID testId, UpdateTestRequestDto request) {
        Teacher teacher = getTeacherService.getCurrentTeacher();
        Subject subject = getSubjectService.getSubjectById(request.subjectId());

        checkTeachService.checkTeacherTeachesSubject(teacher, subject);

        Test test = getTestService.getTestById(testId);

        commandFileService.deleteAllByTest(test);
        commandTestInfoService.deleteAllByTest(test);

        commandTestService.saveTest(Test.builder()
                    .testId(testId)
                    .subjectId(request.subjectId())
                    .title(request.title())
                    .content(request.content())
                    .percent(request.percent())
                    .build()
        );

        for (AttendDataVo attendData: request.attends()) {
            checkAttendService.checkAttendExistByAttendId(attendData.attendId());

            commandTestInfoService.saveTestInfo(TestInfo.builder()
                        .testId(testId)
                        .attendId(attendData.attendId())
                        .endDate(attendData.endDate())
                        .build()
            );
        }

        for (FileDataVO fileData: request.files()) {
            commandFileService.saveFile(File.builder()
                        .testId(Optional.of(testId))
                        .filename(fileData.fileName())
                        .url(fileData.file())
                        .build()
            );
        }
    }
}
