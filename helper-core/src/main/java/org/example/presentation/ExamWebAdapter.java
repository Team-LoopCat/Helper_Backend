package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.StartExamRequestDto;
import org.example.domain.exam.dto.response.GetExamListResponseDto;
import org.example.domain.exam.usecase.StartExamUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExamWebAdapter {
    private final StartExamUseCase startExamUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public GetExamListResponseDto startExam(@Valid @RequestBody StartExamRequestDto requestDto) {
        return startExamUseCase.execute(requestDto);
    }
}
