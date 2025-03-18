package org.example.domain.exam.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.UpdateExamDataDetailRequestDto;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.service.CommandExamDataService;
import org.example.domain.exam.service.GetExamDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateExamDataDetailUseCase {
    private final GetExamDataService getExamDataService;
    private final CommandExamDataService commandExamDataService;

    public void execute(UUID exam_data_id, UpdateExamDataDetailRequestDto request) {
        ExamData currentExamData = getExamDataService.getExamDataById(exam_data_id);

        commandExamDataService.saveExamData(
                ExamData.builder()
                        .examDataId(currentExamData.getExamDataId())
                        .examId(currentExamData.getExamId())
                        .subjectId(currentExamData.getSubjectId())
                        .date(currentExamData.getDate())
                        .problems(request.problems())
                        .percent(request.percent())
                        .content(request.content())
                        .build()
        );
    }
}
