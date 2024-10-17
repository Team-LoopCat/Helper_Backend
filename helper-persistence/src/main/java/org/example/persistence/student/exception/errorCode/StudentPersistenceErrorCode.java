package org.example.persistence.student.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum StudentPersistenceErrorCode implements GlobalErrorCode {
    USER_NOT_EXISTS(404, "유저가 존재하지 않아 정상적으로 매핑되지 않았습니다"),
    GRADE_OR_CLASSROOM_NOT_EXISTS(404, "존재하지 않는 학년/반입니다");


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
