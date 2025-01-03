package org.example.domain.student.dto.request;

import java.util.UUID;

public record UpdateStudentRequestDto (
        String profile,
        String nickname,
        UUID selectedSubject
) {
}
