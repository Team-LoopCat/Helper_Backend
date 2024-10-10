package org.example.global.security.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.global.security.exception.errorCode.SecurityErrorCode;

public class ForbiddenRoleException extends GlobalBusinessException {
    public static InvalidRoleException Exception = new InvalidRoleException();

    public ForbiddenRoleException() {
        super(SecurityErrorCode.FORBIDDEN_ROLE);
    }
}
