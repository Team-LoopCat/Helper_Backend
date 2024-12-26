package org.example.presentation;

import lombok.RequiredArgsConstructor;
import org.example.domain.teacher.dto.request.CheckIdExistRequestDto;
import org.example.domain.teacher.usecase.CheckIdExistUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherWebAdapter {
    private final CheckIdExistUseCase checkIdExistUseCase;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/check")
    public void checkId(@RequestBody CheckIdExistRequestDto checkIdRequest) {
        checkIdExistUseCase.execute(checkIdRequest);
    }
}
