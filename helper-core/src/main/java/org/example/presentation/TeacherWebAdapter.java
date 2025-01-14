package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.teacher.dto.request.CheckIdExistRequestDto;
import org.example.domain.teacher.dto.request.UpdateTeacherRequestDto;
import org.example.domain.teacher.dto.response.GetTeacherMyResponseDto;
import org.example.domain.teacher.usecase.CheckIdExistUseCase;
import org.example.domain.teacher.usecase.GetTeacherMyUseCase;
import org.example.domain.teacher.usecase.UpdateTeacherUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    private final GetTeacherMyUseCase getTeacherMyUseCase;
    private final UpdateTeacherUseCase updateTeacherUseCase;

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    public void updateTeacher(@Valid @RequestBody UpdateTeacherRequestDto updateTeacherRequest) {
        updateTeacherUseCase.execute(updateTeacherRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/my")
    public GetTeacherMyResponseDto getTeacherMy() {
        return getTeacherMyUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/check")
    public void checkId(@Valid @RequestBody CheckIdExistRequestDto checkIdRequest) {
        checkIdExistUseCase.execute(checkIdRequest);
    }
}
