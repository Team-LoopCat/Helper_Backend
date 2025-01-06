package org.example.domain.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.student.exception.errorCode.StudentErrorCode;

public class EmailNotValidException extends GlobalBusinessException {
    public static final EmailNotValidException EXCEPTION = new EmailNotValidException();

    public EmailNotValidException() { super(StudentErrorCode.EMAIL_NOT_VALID); }
}
