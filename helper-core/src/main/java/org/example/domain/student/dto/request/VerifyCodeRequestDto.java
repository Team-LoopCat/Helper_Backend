package org.example.domain.student.dto.request;

public record VerifyCodeRequestDto (
        String email,
        String code
) {
}
