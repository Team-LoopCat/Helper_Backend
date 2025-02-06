package org.example.domain.exam.dto.response;

import java.util.UUID;
import org.example.domain.exam.model.Exam;

record ExamDetailDto(
        String grade,
        UUID exam_id
) {
    public ExamDetailDto(Exam exam) {
        this(
                exam.getGrade(),
                exam.getExamId()
        );
    }
}