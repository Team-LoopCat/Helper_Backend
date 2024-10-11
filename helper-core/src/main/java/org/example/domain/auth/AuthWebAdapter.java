package org.example.domain.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.usecase.LoginUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthWebAdapter {
    private final LoginUseCase loginUseCase;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto request) {
        return loginUseCase.execute(request);
    }
}
