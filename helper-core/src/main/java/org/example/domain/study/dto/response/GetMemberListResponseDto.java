package org.example.domain.study.dto.response;

import java.util.List;
import org.example.domain.student.model.Student;

public record GetMemberListResponseDto(
        List<GetMemberResponseDto> members
) {
    public static GetMemberListResponseDto from(List<Student> members) {
        return new GetMemberListResponseDto(
                members.stream().map(GetMemberResponseDto::new).toList()
        );
    }
}

record GetMemberResponseDto(
        String studentId,
        String nickname
) {
    public GetMemberResponseDto(Student member) {
        this(
                member.getStudentId(),
                member.getNickname()
        );
    }
}
