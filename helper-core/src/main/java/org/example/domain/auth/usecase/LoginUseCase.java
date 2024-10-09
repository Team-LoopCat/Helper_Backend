package org.example.domain.auth.usecase;


import lombok.RequiredArgsConstructor;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.exception.PasswordMismatchException;
import org.example.domain.auth.exception.UserNotFoundException;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.LoginService;
import org.example.domain.auth.spi.JwtPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginUseCase {
    private final LoginService loginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtPort jwtPort;

    public LoginResponseDto execute(LoginRequestDto requestDto) {
        User user = loginService.getUserById(requestDto.id()).orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!bCryptPasswordEncoder.matches(requestDto.password(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        String accessToken = jwtPort.GenerateAccess(user.getUserId(), user.getRole());
        String refreshToken = jwtPort.GenerateRefresh(user.getUserId());

        return new LoginResponseDto(accessToken, refreshToken);
    }
}
