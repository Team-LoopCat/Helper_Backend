package org.example.global.security.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.common.exception.GlobalErrorCode;
import org.example.global.security.exception.errorCode.SecurityErrorCode;

public class ExpiredTokenException extends GlobalBusinessException {
    public static ExpiredTokenException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() { super(SecurityErrorCode.TOKEN_EXPIRED); }
}
