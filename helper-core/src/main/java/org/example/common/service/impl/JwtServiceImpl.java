package org.example.common.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.service.JwtService;
import org.example.common.spi.JwtPort;
import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.model.Role;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    private final JwtPort jwtPort;

    @Override
    public LoginResponseDto makeJwtTokens(String userId, Role role) {
        String accessToken = jwtPort.GenerateAccess(userId, role);
        String refreshToken = jwtPort.GenerateRefresh(userId);

        return new LoginResponseDto(accessToken, refreshToken);
    }
}
