package org.example.domain.student.dto.request;

public record UpdateStudentRequestDto (
        String nickname,
        String selectedSubject
) {
}
