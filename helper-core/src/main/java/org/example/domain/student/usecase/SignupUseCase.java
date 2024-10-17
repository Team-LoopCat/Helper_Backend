package org.example.domain.student.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.SaveUserService;
import org.example.domain.student.dto.request.SignupRequestDto;
import org.example.domain.student.service.SignupService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SignupUseCase {
    private final SignupService signupService;
    private final SaveUserService saveUserService;
    private final BCryptPasswordEncoder passwordEncoder;

    public void execute(SignupRequestDto request) {
        signupService.checkUserIdExist(request.id());

        signupService.checkEmailExist(request.email());

        signupService.checkGradeInfoExist(request.grade(), request.classroom());

        String encryptedPassword = passwordEncoder.encode(request.password());
        saveUserService.saveUser(User.builder()
                .userId(request.id())
                .role(Role.Student)
                .password(encryptedPassword)
                .build()
        );

        signupService.saveStudent(request);
    }
}
