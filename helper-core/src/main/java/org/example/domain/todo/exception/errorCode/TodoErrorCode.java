package org.example.domain.todo.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum TodoErrorCode implements GlobalErrorCode {
    TODO_NOT_FOUND(404, "존재하지 않는 일정입니다");

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