package org.example.domain.exam.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.UpdateExamDataRequestDto;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.service.CommandExamDataService;
import org.example.domain.exam.service.GetExamDataService;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.service.GetSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateExamDataUseCase {
    private final GetExamDataService getExamDataService;
    private final GetSubjectService getSubjectService;
    private final CommandExamDataService commandExamDataService;

    public void execute(UUID examDataId, UpdateExamDataRequestDto request) {
        ExamData currentExamData = getExamDataService.getExamDataById(examDataId);
        Subject subject = getSubjectService.getSubjectById(request.subjectId());

        commandExamDataService.saveExamData(
                ExamData.builder()
                        .examDataId(currentExamData.getExamDataId())
                        .examId(currentExamData.getExamId())
                        .subjectId(subject.getSubjectId())
                        .date(currentExamData.getDate())
                        .period(currentExamData.getPeriod())
                        .problems(currentExamData.getProblems())
                        .percent(currentExamData.getPercent())
                        .content(currentExamData.getContent())
                        .build()
        );
    }
}
