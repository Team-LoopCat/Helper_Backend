package org.example.domain.exam.dto.response;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.example.domain.exam.model.Exam;
import org.example.domain.student.model.Major;

public record GetExamListResponseDto(
        List<GetExamResponseDto> exams
) {
    public static GetExamListResponseDto from(List<Exam> exams) {
        return new GetExamListResponseDto(
                exams.stream()
                        .collect(Collectors.groupingBy(Exam::getMajor))
                        .entrySet().stream()
                        .map(
                                GetExamResponseDto::new
                        ).toList()
        );
    }
}

record GetExamResponseDto(
        Major major,
        List<ExamDetail> exam
) {
    public GetExamResponseDto(Map.Entry<Major, List<Exam>> entry) {
        this(
                entry.getKey(),
                entry.getValue().stream()
                        .map(
                                ExamDetail::new
                        ).toList()
        );
    }
}

record ExamDetail(
        String grade,
        UUID exam_id
) {
    public ExamDetail(Exam exam) {
        this(
                exam.getGrade(),
                exam.getExamId()
        );
    }
}