package org.example.domain.auth.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.auth.exception.ErrorCode.AuthErrorCode;

public class UserNotFoundException extends GlobalBusinessException {
    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() { super(AuthErrorCode.USER_NOT_FOUND); }
}
