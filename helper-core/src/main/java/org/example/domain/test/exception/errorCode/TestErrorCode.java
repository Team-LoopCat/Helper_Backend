package org.example.domain.test.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum TestErrorCode implements GlobalErrorCode {
    TEST_NOT_FOUND(404, "수행평가를 찾을 수 없습니다");

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
