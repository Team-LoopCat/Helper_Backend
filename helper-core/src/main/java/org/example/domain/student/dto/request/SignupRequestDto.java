package org.example.domain.student.dto.request;

public record SignupRequestDto(
        String grade,
        String classroom,
        String number,
        String id,
        String nickname,
        String password,
        String email,
        String profile
) {}
