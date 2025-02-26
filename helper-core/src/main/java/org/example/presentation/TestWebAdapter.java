package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.test.dto.request.CreateTestRequestDto;
import org.example.domain.test.dto.request.UpdateTestRequestDto;
import org.example.domain.test.dto.response.GetTeacherTestListResponseDto;
import org.example.domain.test.dto.response.GetTestListForStudentResponseDto;
import org.example.domain.test.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestWebAdapter {
    private final CreateTestUseCase createTestUseCase;
    private final UpdateTestUseCase updateTestUseCase;
    private final DeleteTestUseCase deleteTestUseCase;
    private final GetTestListForTeacherUseCase getTestListForTeacherUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createTest(@Valid @RequestBody CreateTestRequestDto request) {
        createTestUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{testId}")
    public void updateTest(@PathVariable("testId") UUID testId, @Valid @RequestBody UpdateTestRequestDto request) {
        updateTestUseCase.execute(testId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{testId}")
    public void deleteTest(@PathVariable("testId") UUID testId) {
        deleteTestUseCase.execute(testId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/admin")
    public GetTeacherTestListResponseDto getTeacherTestList() {
        return getTestListForTeacherUseCase.execute();
    }
}
