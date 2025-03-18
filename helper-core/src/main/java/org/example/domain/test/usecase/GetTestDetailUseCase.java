package org.example.domain.test.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.file.service.GetFileService;
import org.example.domain.file.spi.vo.FileDataVO;
import org.example.domain.subject.model.Attend;
import org.example.domain.subject.service.GetAttendService;
import org.example.domain.teacher.service.GetTeacherService;
import org.example.domain.test.dto.response.GetTestDetailResponseDto;
import org.example.domain.test.service.GetTestService;
import org.example.domain.test.spi.vo.TestDetailVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetTestDetailUseCase {
    private final GetTestService getTestService;
    private final GetFileService getFileService;
    private final GetAttendService getAttendService;
    private final GetTeacherService getTeacherService;

    public GetTestDetailResponseDto execute(UUID testId) {
        TestDetailVO testDetail = getTestService.getTestDetailById(testId);
        List<FileDataVO> fileData = getFileService.getAllFileByTestId(testId);
        List<Attend> attends = getAttendService.getAttendsByTestId(testId);
        List<String> teacherNames = getTeacherService.getTeacherNamesBySubjectId(testDetail.subjectId());

        return GetTestDetailResponseDto.of(testDetail, teacherNames, attends, fileData);
    }
}
