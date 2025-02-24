package org.example.presentation;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.dto.request.ExamDataRequestDto;
import org.example.domain.exam.dto.request.StartExamRequestDto;
import org.example.domain.exam.dto.request.UpdateExamDataDetailRequestDto;
import org.example.domain.exam.dto.request.UpdateExamDataRequestDto;
import org.example.domain.exam.dto.response.GetExamListResponseDto;
import org.example.domain.exam.dto.response.PostExamDataResponseDto;
import org.example.domain.exam.dto.response.StartExamResponseDto;
import org.example.domain.exam.usecase.GetExamUseCase;
import org.example.domain.exam.usecase.PostExamDataUseCase;
import org.example.domain.exam.usecase.StartExamUseCase;
import org.example.domain.exam.usecase.UpdateExamDataDetailUseCase;
import org.example.domain.exam.usecase.UpdateExamDataUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam")
public class ExamWebAdapter {
    private final PostExamDataUseCase postExamDataUseCase;
    private final UpdateExamDataUseCase updateExamDataUseCase;
    private final UpdateExamDataDetailUseCase updateExamDataDetailUseCase;
    private final StartExamUseCase startExamUseCase;
    private final GetExamUseCase getExamUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{exam_id}")
    public PostExamDataResponseDto postExamData(@PathVariable UUID exam_id, @Valid @RequestBody ExamDataRequestDto request) {
        return postExamDataUseCase.execute(request, exam_id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{exam_data_id}")
    public void updateExamData(@PathVariable UUID exam_data_id, @Valid @RequestBody UpdateExamDataRequestDto request) {
        updateExamDataUseCase.execute(exam_data_id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/detail/{exam_data_id}")
    public void updateExamDataDetail(@PathVariable UUID exam_data_id, @Valid @RequestBody UpdateExamDataDetailRequestDto request) {
        updateExamDataDetailUseCase.execute(exam_data_id, request);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public StartExamResponseDto startExam(@Valid @RequestBody StartExamRequestDto requestDto) {
        return startExamUseCase.execute(requestDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public GetExamListResponseDto getExamList() {
        return getExamUseCase.execute();
    }
}
