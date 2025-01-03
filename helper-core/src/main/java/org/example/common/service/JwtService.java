package org.example.common.service;

import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.model.Role;

public interface JwtService {

    LoginResponseDto makeJwtTokens(String userId, Role role);
}
