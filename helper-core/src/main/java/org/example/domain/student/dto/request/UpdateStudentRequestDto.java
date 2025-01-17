package org.example.domain.student.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record UpdateStudentRequestDto (
        @Nullable String profile,
        @NotBlank String nickname,
        @Nullable UUID selectedSubject
) {
}
