package org.example.domain.auth.usecase;


import lombok.RequiredArgsConstructor;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginUseCase {
    private final LoginService loginService;

    public LoginResponseDto execute(LoginRequestDto requestDto) {

        User user = loginService.getUserById(requestDto.id());

        loginService.checkPasswordMatches(requestDto.password(), user.getPassword());

        return loginService.makeJwtTokens(user.getUserId(), user.getRole());
    }
}
