package org.example.domain.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.student.exception.errorCode.StudentErrorCode;

public class EmailAlreadyExistsException extends GlobalBusinessException {
    public static final EmailAlreadyExistsException EXCEPTION = new EmailAlreadyExistsException();

    public EmailAlreadyExistsException() { super(StudentErrorCode.EMAIL_ALREADY_EXISTS); }
}
