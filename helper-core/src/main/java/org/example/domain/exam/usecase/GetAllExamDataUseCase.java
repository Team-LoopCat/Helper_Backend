package org.example.domain.exam.usecase;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.response.GetExamDataListRequestDto;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.service.GetExamDataService;
import org.example.domain.exam.service.GetExamService;
import org.example.domain.exam.spi.vo.SimpleExamDataVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetAllExamDataUseCase {
    private final GetExamService getExamService;
    private final GetExamDataService getExamDataService;

    public GetExamDataListRequestDto execute(UUID examId) {
        Exam exam = getExamService.getExamById(examId);

        List<SimpleExamDataVO> examData = getExamDataService.getAllExamDataByExamDataId(exam.getExamId());

        return GetExamDataListRequestDto.from(examData);
    }
}
