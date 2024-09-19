package org.example.global.exception;

public class BusinessException extends RuntimeException {
    public final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) { this.errorCode = errorCode; }
}
