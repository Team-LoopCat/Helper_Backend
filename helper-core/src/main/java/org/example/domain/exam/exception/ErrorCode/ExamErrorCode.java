package org.example.domain.exam.exception.ErrorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum ExamErrorCode implements GlobalErrorCode {
    ALREADY_STARTED(409, "이미 시험이 시작되었습니다");

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
