package org.example.domain.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.usecase.LoginUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthWebAdapter {
    private final LoginUseCase loginUseCase;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto request) {
        return loginUseCase.execute(request);
    }
}
