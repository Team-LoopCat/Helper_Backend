package org.example.global.security.exception;

import org.example.global.exception.BusinessException;
import org.example.global.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public static InvalidTokenException Exception = new InvalidTokenException();
    public InvalidTokenException() { super(ErrorCode.INVALID_TOKEN); }
}
