package org.example.domain.subject.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum AttendErrorCode implements GlobalErrorCode {
    SUBJECT_NOT_FOUND(404, "요청하신 수강 정보가 존재하지 않습니다");

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
