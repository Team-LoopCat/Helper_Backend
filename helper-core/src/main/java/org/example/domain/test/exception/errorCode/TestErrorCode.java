package org.example.domain.test.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum TestErrorCode implements GlobalErrorCode {
    TEST_NOT_FOUND(404, "존재하지 않는 수행평가입니다");

    private final int errorStatus;
    private final String errorMessage;

    @Override
    public int getErrorStatus() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
