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
import org.example.domain.test.dto.request.CreateTestRequestDto;
import org.example.domain.test.dto.vo.AttendDataVo;
import org.example.domain.test.model.Test;
import org.example.domain.test.model.TestInfo;
import org.example.domain.test.service.CommandTestInfoService;
import org.example.domain.test.service.CommandTestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateTestUseCase {
    private final GetTeacherService getTeacherService;
    private final GetSubjectService getSubjectService;
    private final CheckTeachService checkTeachService;
    private final CommandTestService commandTestService;
    private final CommandFileService commandFileService;
    private final CommandTestInfoService commandTestInfoService;
    private final CheckAttendService checkAttendService;

    public void execute(CreateTestRequestDto request) {
        Teacher teacher = getTeacherService.getCurrentTeacher();
        Subject subject = getSubjectService.getSubjectById(request.subjectId());
        checkTeachService.checkTeacherTeachesSubject(teacher, subject);

        Test createdTest = commandTestService.saveTest(Test.builder()
                .title(request.title())
                .subjectId(request.subjectId())
                .content(request.content())
                .percent(request.percent())
                .build()
        );

        for (FileDataVO fileData : request.files()) {
            commandFileService.saveFile(File.builder()
                    .testId(Optional.of(createdTest.getTestId()))
                    .filename(fileData.fileName())
                    .url(fileData.file())
                    .build()
            );
        }

        for (AttendDataVo attendData : request.attends()) {
            checkAttendService.checkAttendExistByAttendId(attendData.attendId());

            commandTestInfoService.saveTestInfo(TestInfo.builder()
                    .testId(createdTest.getTestId())
                    .attendId(attendData.attendId())
                    .endDate(attendData.endDate())
                    .build()
            );
        }
    }
}
