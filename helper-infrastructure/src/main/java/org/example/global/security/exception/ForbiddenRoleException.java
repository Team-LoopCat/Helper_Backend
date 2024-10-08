package org.example.global.security.exception;

import org.example.global.exception.BusinessException;
import org.example.global.exception.ErrorCode;

public class ForbiddenRoleException extends BusinessException {
    public static InvalidRoleException Exception = new InvalidRoleException();

    public ForbiddenRoleException() {
        super(ErrorCode.FORBIDDEN_ROLE);
    }
}
