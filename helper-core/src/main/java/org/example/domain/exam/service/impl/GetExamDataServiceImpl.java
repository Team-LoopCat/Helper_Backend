package org.example.domain.exam.service.impl;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.exception.ExamDataNotFoundException;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.service.GetExamDataService;
import org.example.domain.exam.spi.QueryExamDataPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetExamDataServiceImpl implements GetExamDataService {
    private final QueryExamDataPort queryExamDataPort;

    public ExamData getExamDataById(UUID examDataId) {
        return queryExamDataPort.queryExamDataById(examDataId).orElseThrow(
                () -> ExamDataNotFoundException.EXCEPTION
        );
    }
}
