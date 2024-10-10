package org.example.domain.auth.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.auth.exception.ErrorCode.AuthErrorCode;

public class PasswordMismatchException extends GlobalBusinessException {
    public static final PasswordMismatchException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() { super(AuthErrorCode.PASSWORD_MISMATCHES); }
}
