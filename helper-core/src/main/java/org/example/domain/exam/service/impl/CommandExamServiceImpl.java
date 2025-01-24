package org.example.domain.exam.service.impl;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.MajorGradeRequestDto;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.service.CommandExamService;
import org.example.domain.exam.spi.QueryExamPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandExamServiceImpl implements CommandExamService {
    private final QueryExamPort queryExamPort;

    @Override
    public List<Exam> startExam(LocalDate deadline, LocalDate start, LocalDate end, List<MajorGradeRequestDto> grades) {
        List<Exam> exams = grades.stream()
                .map(grade ->
                        Exam.builder()
                                .start(start)
                                .end(end)
                                .major(grade.major())
                                .grade(grade.grade())
                                .deadline(deadline)
                                .build()
                ).toList();

        return queryExamPort.saveAll(exams);
    }

    @Override
    public void deleteAllExams() {
        queryExamPort.deleteAllExams();
    }
}
