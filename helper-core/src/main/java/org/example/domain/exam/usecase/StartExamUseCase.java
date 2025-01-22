package org.example.domain.exam.usecase;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.StartExamRequestDto;
import org.example.domain.exam.dto.response.GetExamListResponseDto;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.service.CheckExamService;
import org.example.domain.exam.service.CommandExamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StartExamUseCase {
    private final CommandExamService commandExamService;
    private final CheckExamService checkExamService;

    public GetExamListResponseDto execute(StartExamRequestDto request) {
        checkExamService.checkExamHasStarted();

        List<Exam> exams = commandExamService.startExam(
                request.deadline(),
                request.start(),
                request.end(),
                request.grades()
        );

        return GetExamListResponseDto.from(exams);
    }
}
