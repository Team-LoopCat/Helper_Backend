package org.example.domain.exam.service;

import java.time.LocalDate;
import java.util.List;
import org.example.domain.exam.dto.request.MajorGradeRequestDto;
import org.example.domain.exam.model.Exam;

public interface CommandExamService {

    List<Exam> startExam(LocalDate deadline, LocalDate start, LocalDate end, List<MajorGradeRequestDto> grades);

    void deleteAllExams();
}
