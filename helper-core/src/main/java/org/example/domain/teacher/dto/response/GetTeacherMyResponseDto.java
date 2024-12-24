package org.example.domain.teacher.dto.response;

import java.util.List;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;
import org.example.domain.teacher.model.Teacher;

public record GetTeacherMyResponseDto(
        String name,
        String id,
        String profile_image,
        List<SubjectAndAttendVO> subjects
) {
    public static GetTeacherMyResponseDto of(Teacher teacher, String profile_image, List<SubjectAndAttendVO> subjects) {
        return new GetTeacherMyResponseDto(
                teacher.getName(),
                teacher.getUserId(),
                profile_image,
                subjects
        );
    }
}
