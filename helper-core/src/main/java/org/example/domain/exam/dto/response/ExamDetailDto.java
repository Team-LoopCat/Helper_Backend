package org.example.domain.exam.dto.response;

import java.util.UUID;
import org.example.domain.exam.model.Exam;
import org.example.domain.student.model.Major;

record ExamDetailDto(
        Major major,
        UUID exam_id
) {
    public ExamDetailDto(Exam exam) {
        this(
                exam.getMajor(),
                exam.getExamId()
        );
    }
}