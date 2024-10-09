package org.example.domain.auth.exception;

import org.example.common.exception.CoreBusinessException;
import org.example.domain.auth.exception.ErrorCode.AuthErrorCode;

public class PasswordMismatchException extends CoreBusinessException {
    public static final PasswordMismatchException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() { super(AuthErrorCode.PASSWORD_MISMATCHES()); }
}
