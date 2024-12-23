package org.example.domain.student.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.auth.service.GetUserService;
import org.example.domain.student.dto.response.GetMyInfoResponseDto;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.subject.service.GetSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetMyInfoUseCase {
    private final SecurityService securityService;
    private final GetUserService getUserService;
    private final GetStudentService getStudentService;
    private final GetSubjectService getSubjectService;

    public GetMyInfoResponseDto execute() {
        String userId = securityService.getCurrentUserId();
        User user = getUserService.getUserById(userId);
        Student student = getStudentService.getStudentByUserId(user);

        String selectedSubject;
        if (student.getSubjectId().isPresent()) {
            selectedSubject = getSubjectService.getSubjectById(student.getSubjectId().get()).getName();
        } else {
            selectedSubject = null;
        }

        return new GetMyInfoResponseDto(user.getProfile(), student.getNickname(), selectedSubject);
    }
}
