package org.example.domain.auth.dto.request;

public record LoginRequestDto(
        String id,
        String password
) {}
