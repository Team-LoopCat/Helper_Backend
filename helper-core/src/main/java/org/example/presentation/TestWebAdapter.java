package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.test.dto.request.CreateTestRequestDto;
import org.example.domain.test.usecase.CreateTestUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestWebAdapter {
    private final CreateTestUseCase createTestUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createTest(@Valid @RequestBody CreateTestRequestDto request) {
        createTestUseCase.execute(request);
    }
}
