package org.example.domain.exam.dto.response;

import java.util.List;
import org.example.domain.exam.model.Exam;

public record StartExamResponseDto(
        List<ExamDetailDto> exams
) {
    public static StartExamResponseDto from(List<Exam> exams) {
        return new StartExamResponseDto(
                exams.stream().map(
                        ExamDetailDto::new
                ).toList()
        );
    }
}
