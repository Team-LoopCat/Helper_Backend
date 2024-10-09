package org.example.global.exception;

import org.example.common.exception.GlobalErrorCode;

import java.time.LocalDateTime;

public record ErrorResponse (
        Integer errorCode,
        String message,
        String description,
        LocalDateTime timestamp
) {
    public static ErrorResponse of (ErrorCode errorCode, String description) {
        return new ErrorResponse(errorCode.getCode(), errorCode.getMessage(), description, LocalDateTime.now());
    }

    public static ErrorResponse of (GlobalErrorCode errorCode, String description) {
        return new ErrorResponse(errorCode.getErrorStatus(), errorCode.getErrorMessage(), description, LocalDateTime.now());
    }
}
