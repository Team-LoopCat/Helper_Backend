package org.example.presentation;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.dto.request.ChangePasswordRequestDto;
import org.example.domain.student.dto.request.SendCodeRequestDto;
import org.example.domain.student.dto.request.SignupRequestDto;
import org.example.domain.student.dto.request.VerifyCodeRequestDto;
import org.example.domain.student.dto.response.GetMyInfoResponseDto;
import org.example.domain.student.usecase.*;
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
    private final VerifyCodeUseCase verifyCodeUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;

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
    @PostMapping("/email/verify")
    public void verifyCode (@RequestBody VerifyCodeRequestDto request) {
        verifyCodeUseCase.execute(request);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/profile")
    public void updateUser (@RequestBody UpdateStudentRequestDto request) {
        updateUserUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/password")
    public void changePassword(@RequestBody ChangePasswordRequestDto request) {
        changePasswordUseCase.execute(request);
    }
}
