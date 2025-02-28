package org.example.domain.auth.usecase;


import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.common.service.JwtService;
import org.example.domain.auth.dto.request.LoginRequestDto;
import org.example.domain.auth.dto.response.LoginResponseDto;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.GetUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginUseCase {
    private final GetUserService getUserService;
    private final SecurityService securityService;
    private final JwtService jwtService;

    public LoginResponseDto execute(LoginRequestDto request) {

        User user = getUserService.getUserById(request.id());

        securityService.checkPasswordMatches(request.password(), user.getPassword());

        return jwtService.makeJwtTokens(user.getUserId(), user.getRole());
    }
}
