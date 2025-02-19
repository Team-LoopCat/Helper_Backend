package org.example.domain.exam.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.ExamDataRequestDto;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.service.CommandExamDataService;
import org.example.domain.exam.spi.QueryExamDataPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommandExamDataServiceImpl implements CommandExamDataService {
    private final QueryExamDataPort queryExamDataPort;

    @Override
    public List<ExamData> saveAllExamData(Exam exam, List<ExamDataRequestDto> examData) {
        return queryExamDataPort.saveAllExamData(
                examData.stream().map(data ->
                        ExamData.builder()
                                .examId(exam.getExamId())
                                .subjectId(data.subjectId())
                                .date(data.date())
                                .period(data.period())
                                .build()
                ).toList()
        );
    }
}
