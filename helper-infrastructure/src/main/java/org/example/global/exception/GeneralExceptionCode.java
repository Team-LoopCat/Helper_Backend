package org.example.global.exception;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum GeneralExceptionCode implements GlobalErrorCode {
    BAD_REQUEST(400, "유효하지 않은 요청입니다"),
    INTERNAL_SERVER_ERROR(500, "서버 오류입니다");

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
