package org.example.domain.student.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.CheckUserService;
import org.example.domain.auth.service.CommandUserService;
import org.example.domain.student.dto.request.SignupRequestDto;
import org.example.domain.student.service.CheckGradeInfoService;
import org.example.domain.student.service.CheckStudentService;
import org.example.domain.student.service.CommandStudentService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SignupUseCase {
    private final CheckUserService checkUserService;
    private final CheckStudentService checkStudentService;
    private final CheckGradeInfoService checkGradeInfoService;
    private final CommandUserService commandUserService;
    private final CommandStudentService commandStudentService;
    private final BCryptPasswordEncoder passwordEncoder;

    public void execute(SignupRequestDto request) {
        checkUserService.checkUserExistsById(request.id());

        checkStudentService.checkStudentExistByEmail(request.email());

        checkGradeInfoService.checkGradeInfoExist(request.grade(), request.classroom());

        String encryptedPassword = passwordEncoder.encode(request.password());
        commandUserService.saveUser(User.builder()
                .userId(request.id())
                .role(Role.Student)
                .password(encryptedPassword)
                .build()
        );

        commandStudentService.saveStudent(request);
    }
}
