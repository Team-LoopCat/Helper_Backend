package org.example.domain.teacher.usecase;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.auth.service.GetUserService;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.service.GetSubjectService;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;
import org.example.domain.teacher.dto.response.GetTeacherMyResponseDto;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.service.GetTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetTeacherMyUseCase {
    private final GetTeacherService getTeacherService;
    private final GetSubjectService getSubjectService;
    private final GetUserService getUserService;

    public GetTeacherMyResponseDto execute() {
        Teacher teacher = getTeacherService.getCurrentTeacher();
        String profileImage = getUserService.getProfileImageById(teacher.getUserId());

        List<SubjectAndAttendVO> subjects = getSubjectService.getSubjectsAndAttendsByTeacherId(teacher.getTeacherId());

        return GetTeacherMyResponseDto.of(teacher, profileImage, subjects);
    }
}
