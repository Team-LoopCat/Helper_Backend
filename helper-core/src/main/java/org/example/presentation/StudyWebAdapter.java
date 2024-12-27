package org.example.presentation;

import lombok.RequiredArgsConstructor;
import org.example.domain.study.dto.request.PostStudyRequestDto;
import org.example.domain.study.dto.response.PostStudyResponseDto;
import org.example.domain.study.usecase.PostStudyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyWebAdapter {
    private final PostStudyUseCase postStudyUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PostStudyResponseDto postStudy(@RequestBody PostStudyRequestDto postStudyRequest) {
        return postStudyUseCase.execute(postStudyRequest);
    }
}
