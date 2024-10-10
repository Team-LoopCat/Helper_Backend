package org.example.domain.auth.exception.ErrorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum AuthErrorCode implements GlobalErrorCode {
    PASSWORD_MISMATCHES(403, "비밀번호가 일치하지 않습니다"),
    USER_NOT_FOUND(404, "존재하지 않는 유저입니다");

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
