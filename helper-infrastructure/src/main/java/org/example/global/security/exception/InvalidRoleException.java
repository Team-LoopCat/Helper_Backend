package org.example.global.security.exception;

import org.example.global.exception.BusinessException;
import org.example.global.exception.ErrorCode;

public class InvalidRoleException extends BusinessException {
    public static InvalidRoleException Exception = new InvalidRoleException();

    public InvalidRoleException() {
        super(ErrorCode.INVALID_ROLE);
    }
}
