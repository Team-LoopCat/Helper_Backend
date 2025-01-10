package org.example.domain.student.dto.request;

public record ChangePasswordRequestDto(
        String oldPassword,
        String password
) {}