package org.example.presentation;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.dto.request.SendCodeRequestDto;
import org.example.domain.student.dto.request.SignupRequestDto;
import org.example.domain.student.dto.response.GetMyInfoResponseDto;
import org.example.domain.student.usecase.GetMyInfoUseCase;
import org.example.domain.student.usecase.DeleteStudentUseCase;
import org.example.domain.student.usecase.SendCodeUseCase;
import org.example.domain.student.usecase.SignupUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentWebAdapter {
    private final SignupUseCase signupUseCase;
    private final GetMyInfoUseCase getMyInfoUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;
    private final SendCodeUseCase sendCodeUseCase;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/signup")
    public void signup (@RequestBody SignupRequestDto request) {
        signupUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/my")
    public GetMyInfoResponseDto getMyInfo () {
        return getMyInfoUseCase.execute();
    }
  
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteStudent () {
        deleteStudentUseCase.execute();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/email/send")
    public void sendCode (@RequestBody SendCodeRequestDto request) {
        sendCodeUseCase.execute(request);
    }
}
