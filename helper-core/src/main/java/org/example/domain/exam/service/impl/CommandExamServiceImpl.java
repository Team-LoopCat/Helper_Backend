package org.example.domain.exam.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.ExamDataRequestDto;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.service.CommandExamService;
import org.example.domain.exam.spi.QueryExamPort;
import org.example.domain.student.model.Major;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandExamServiceImpl implements CommandExamService {
    private final QueryExamPort queryExamPort;

    @Override
    public Exam startExam(Major major, String grade, List<ExamDataRequestDto> examData) {
        Exam exam = queryExamPort.saveExam(
                Exam.builder()
                    .major(major)
                    .grade(grade)
                    .build()
        );

        queryExamPort.saveAllExamData(
            examData.stream().map(data ->
                ExamData.builder()
                        .examId(exam.getExamId())
                        .date(data.date())
                        .period(data.period())
                        .build()
            ).toList()
        );

        return exam;
    }
}
