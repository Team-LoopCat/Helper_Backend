package org.example.domain.auth.dto.response;

public record LoginResponseDto(
        String accessToken,
        String refreshToken
) {
}
