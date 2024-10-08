package org.example.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // JWT Error
    INVALID_TOKEN(400, "잘못된 토큰입니다"),
    INVALID_ROLE(400, "유효하지 않은 역할입니다"),
    FORBIDDEN_ROLE(403, "권한이 없는 사용자입니다"),

    // Common
    BAD_REQUEST(400, "잘못된 요청"),
    INTERNAL_SERVER_ERROR(500, "서버 에러");

    private final Integer code;
    private final String message;
}
