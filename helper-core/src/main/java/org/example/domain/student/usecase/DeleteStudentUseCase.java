package org.example.domain.student.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.JwtService;
import org.example.common.service.SecurityService;
import org.example.domain.auth.service.CommandUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteStudentUseCase {
    private final CommandUserService commandUserService;
    private final SecurityService securityService;

    public void execute() {
        commandUserService.deleteUser(securityService.getCurrentUserId());
    }
}
