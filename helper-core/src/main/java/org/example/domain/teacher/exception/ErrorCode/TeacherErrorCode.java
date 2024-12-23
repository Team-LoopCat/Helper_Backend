package org.example.domain.teacher.exception.ErrorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum TeacherErrorCode implements GlobalErrorCode {
    ID_ALREADY_EXIST(409, "이미 존재하는 아이디입니다.");

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

