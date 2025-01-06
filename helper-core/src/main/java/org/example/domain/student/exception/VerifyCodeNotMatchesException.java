package org.example.domain.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.student.exception.errorCode.StudentErrorCode;

public class VerifyCodeNotMatchesException extends GlobalBusinessException {
    public static final VerifyCodeNotMatchesException EXCEPTION = new VerifyCodeNotMatchesException();

    public VerifyCodeNotMatchesException() { super(StudentErrorCode.VERIFY_CODE_NOT_MATCHES); }
}
