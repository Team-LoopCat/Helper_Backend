package org.example.domain.test.dto.response;

import org.example.domain.file.spi.vo.FileDataVO;
import org.example.domain.subject.model.Attend;
import org.example.domain.test.spi.vo.TestDetailVO;

import java.util.List;
import java.util.UUID;

public record GetTestDetailResponseDto(
        UUID id,
        String title,
        String subject,
        String teacher,
        String content,
        int percent,
        List<Attend> attends,
        List<FileDataVO> files
) {
    public static GetTestDetailResponseDto of(TestDetailVO test, List<String> teacherNames, List<Attend> attends, List<FileDataVO> fileData) {
        return  new GetTestDetailResponseDto(test.id(), test.title(), test.subject(), String.join(", ", teacherNames), test.content(), test.percent(), attends, fileData);
    }
}
