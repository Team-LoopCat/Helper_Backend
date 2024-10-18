package org.example.common.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.common.spi.SecurityPort;
import org.example.domain.auth.exception.PasswordMismatchException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {
    private final SecurityPort securityPort;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String getCurrentUserId() {
        return securityPort.getCurrentUserId();
    }


    @Override
    public void checkPasswordMatches(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }
}
