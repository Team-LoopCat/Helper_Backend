package org.example.domain.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.exception.PasswordMismatchException;
import org.example.domain.auth.model.Role;
import org.example.domain.auth.service.LoginService;
import org.example.common.spi.JwtPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final JwtPort jwtPort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void checkPasswordMatches(String rawPassword, String encodedPassword) {
        if (!bCryptPasswordEncoder.matches(rawPassword, encodedPassword)) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }
}
