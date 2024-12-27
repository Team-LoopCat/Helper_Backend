package org.example.domain.student.dto.response;

public record GetMyInfoResponseDto(
    String profile,
    String nickname,
    String selectedSubject
) { }
