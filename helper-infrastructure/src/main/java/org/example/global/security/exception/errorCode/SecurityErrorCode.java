package org.example.global.security.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum SecurityErrorCode implements GlobalErrorCode {

    // JWT Error
    INVALID_TOKEN(400, "잘못된 토큰입니다"),
    TOKEN_EXPIRED(401, "토큰이 만료되었습니다."),
    INVALID_ROLE(400, "유효하지 않은 역할입니다"),
    FORBIDDEN_ROLE(403, "권한이 없는 사용자입니다");

    private final int errorStatus;
    private final String errorMessage;

    @Override
    public int getErrorStatus() {
        return errorStatus;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
