package org.example.domain.exam.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.service.GetExamService;
import org.example.domain.exam.spi.QueryExamPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetExamServiceImpl implements GetExamService {
    private final QueryExamPort queryExamPort;

    @Override
    public List<Exam> getExamList() {
        return queryExamPort.queryAllExams();
    }
}
