package org.example.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.exception.PasswordMismatchException;
import org.example.domain.auth.exception.UserNotFoundException;
import org.example.domain.auth.model.Role;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.LoginService;
import org.example.domain.auth.spi.JwtPort;
import org.example.domain.auth.spi.QueryAuthPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final JwtPort jwtPort;
    private final QueryAuthPort queryAuthPort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getUserById(String id) {
        return queryAuthPort.getUserById(id).orElseThrow(
                () -> UserNotFoundException.EXCEPTION
        );
    }

    @Override
    public void checkPasswordMatches(String rawPassword, String encodedPassword) {
        if (!bCryptPasswordEncoder.matches(rawPassword, encodedPassword)) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }

    @Override
    public LoginResponseDto makeJwtTokens(String userId, Role role) {
        String accessToken = jwtPort.GenerateAccess(userId, role);
        String refreshToken = jwtPort.GenerateRefresh(userId);

        return new LoginResponseDto(accessToken, refreshToken);
    }
}
