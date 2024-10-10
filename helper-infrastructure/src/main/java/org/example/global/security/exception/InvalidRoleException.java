package org.example.global.security.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.global.security.exception.errorCode.SecurityErrorCode;

public class InvalidRoleException extends GlobalBusinessException {
    public static InvalidRoleException Exception = new InvalidRoleException();

    public InvalidRoleException() {
        super(SecurityErrorCode.INVALID_ROLE);
    }
}
