package org.example.domain.student.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.CommandUserService;
import org.example.domain.student.dto.request.ChangePasswordRequestDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangePasswordUseCase {
    private final CommandUserService commandUserService;
    private final SecurityService securityService;
    private final BCryptPasswordEncoder passwordEncoder;

    public void execute(ChangePasswordRequestDto request) {
        User user = securityService.getCurrentUser();

        securityService.checkPasswordMatches(request.oldPassword(), user.getPassword());

        commandUserService.saveUser(User.builder()
                .userId(user.getUserId())
                .password(passwordEncoder.encode(request.password()))
                .role(user.getRole())
                .profile(user.getProfile())
                .build()
        );
    }
}
