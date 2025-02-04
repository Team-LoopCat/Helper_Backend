package org.example.domain.exam.service;

import java.util.List;
import org.example.domain.exam.dto.request.ExamDataRequestDto;
import org.example.domain.exam.model.Exam;
import org.example.domain.student.model.Major;

public interface CommandExamService {

    Exam startExam(Major major, String grade, List<ExamDataRequestDto> examData);
}
