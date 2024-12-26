package org.example.domain.teacher.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.CommandUserService;
import org.example.domain.teacher.dto.request.UpdateTeacherRequestDto;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.service.CommandTeacherService;
import org.example.domain.teacher.service.GetTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateTeacherUseCase {
    private final SecurityService securityService;
    private final GetTeacherService getTeacherService;
    private final CommandTeacherService commandTeacherService;
    private final CommandUserService commandUserService;

    public void execute(UpdateTeacherRequestDto request) {
        User currentUser = securityService.getCurrentUser();
        Teacher currentTeacher = getTeacherService.getTeacherByUserId(currentUser.getUserId());

        commandTeacherService.saveTeacher(
            new Teacher(
                currentTeacher.getTeacherId(),
                request.id(),
                currentTeacher.getName()
            )
        );

        commandUserService.saveUser(
            new User(
                request.id(),
                currentUser.getPassword(),
                currentUser.getRole(),
                request.profile_image()
            )
        );
    }
}
