package org.example.domain.student.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.FileService;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.CommandUserService;
import org.example.domain.student.dto.request.UpdateStudentRequestDto;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.CommandStudentService;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.subject.service.GetSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final FileService fileService;
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final CommandUserService commandUserService;
    private final CommandStudentService commandStudentService;

    public void execute(MultipartFile profile, UpdateStudentRequestDto request) {
        User user = securityService.getCurrentUser();
        Student student = getStudentService.getStudentByUserId(user);

        if (profile != null && !profile.isEmpty()) {
            String profileUrl = fileService.uploadFile(profile);
            System.out.println(profileUrl);

            commandUserService.saveUser(
                    User.builder()
                            .userId(user.getUserId())
                            .password(user.getPassword())
                            .role(user.getRole())
                            .profile(profileUrl)
                            .build()
            );
        }

        Optional<UUID> subjectId = Optional.ofNullable(request.selectedSubject() != null ?
                UUID.fromString(request.selectedSubject()) :
                null
        );
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
