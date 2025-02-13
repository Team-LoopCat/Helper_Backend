package org.example.domain.subject.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum TeachErrorCode implements GlobalErrorCode {
    TEACH_NOT_FOUND(403, "해당 과목을 가르치고 있지 않습니다");

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
