package org.example.domain.exam.service.impl;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.exception.ExamDataNotFoundException;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.service.GetExamDataService;
import org.example.domain.exam.spi.QueryExamDataPort;
import org.example.domain.exam.spi.vo.SimpleExamDataVO;
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

    @Override
    public List<SimpleExamDataVO> getAllExamDataByExamDataId(UUID examDataId) {
        return queryExamDataPort.queryAllExamDataByExamDataId(examDataId);
    }
}
