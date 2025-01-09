package org.example.domain.student.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.CommandUserService;
import org.example.domain.student.dto.request.UpdateStudentRequestDto;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.CommandStudentService;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final CommandUserService commandUserService;
    private final CommandStudentService commandStudentService;

    public void execute(UpdateStudentRequestDto request) {
        User user = securityService.getCurrentUser();
        Student student = getStudentService.getStudentByUser(user);

        if (request.profile() != null && !request.profile().isEmpty()) {
            commandUserService.saveUser(
                    User.builder()
                            .userId(user.getUserId())
                            .password(user.getPassword())
                            .role(user.getRole())
                            .profile(request.profile())
                            .build()
            );
        }

        Optional<UUID> subjectId = Optional.ofNullable(request.selectedSubject());
        commandStudentService.saveStudent(
                Student.builder()
                        .studentId(student.getStudentId())
                        .grade(student.getGrade())
                        .classroom(student.getClassroom())
                        .nickname(request.nickname())
                        .subjectId(subjectId)
                        .email(student.getEmail())
                        .userId(student.getUserId())
                        .build()
        );
    }
}
