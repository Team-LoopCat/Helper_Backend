package org.example.domain.exam.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.ExamDataRequestDto;
import org.example.domain.exam.dto.response.PostExamDataResponseDto;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.service.CheckExamDataService;
import org.example.domain.exam.service.CommandExamDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostExamDataUseCase {
    private final CheckExamDataService checkExamDataService;
    private final CommandExamDataService commandExamDataService;

    public PostExamDataResponseDto execute(ExamDataRequestDto examDataRequestDto, UUID examId) {
        checkExamDataService.checkDateOrPeriodHasBeenDuplicated(examDataRequestDto.date(), examDataRequestDto.period());

        ExamData currentExamData = commandExamDataService.saveExamData(
                ExamData.builder()
                        .examId(examId)
                        .subjectId(examDataRequestDto.subjectId())
                        .date(examDataRequestDto.date())
                        .period(examDataRequestDto.period())
                        .build()
        );

        return new PostExamDataResponseDto(currentExamData.getExamDataId());
    }
}
