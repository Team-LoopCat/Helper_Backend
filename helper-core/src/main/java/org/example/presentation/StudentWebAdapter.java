package org.example.presentation;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.dto.request.SendCodeRequestDto;
import org.example.domain.student.dto.request.SignupRequestDto;
import org.example.domain.student.dto.request.UpdateStudentRequestDto;
import org.example.domain.student.dto.response.GetMyInfoResponseDto;
import org.example.domain.student.usecase.GetMyInfoUseCase;
import org.example.domain.student.usecase.DeleteStudentUseCase;
import org.example.domain.student.usecase.SendCodeUseCase;
import org.example.domain.student.usecase.SignupUseCase;
import org.example.domain.student.usecase.UpdateUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentWebAdapter {
    private final SignupUseCase signupUseCase;
    private final GetMyInfoUseCase getMyInfoUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;
    private final SendCodeUseCase sendCodeUseCase;
    private final UpdateUserUseCase updateUserUseCase;

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

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/profile")
    public void updateUser (@RequestPart(value = "profile", required = false) MultipartFile file, @RequestPart("body") UpdateStudentRequestDto request) {
        updateUserUseCase.execute(file, request);
    }
}
