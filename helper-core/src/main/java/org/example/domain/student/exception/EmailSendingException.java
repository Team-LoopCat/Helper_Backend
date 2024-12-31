package org.example.domain.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.student.exception.errorCode.StudentErrorCode;

public class EmailSendingException extends GlobalBusinessException {
    public static final EmailSendingException EXCEPTION = new EmailSendingException();

    public EmailSendingException() { super(StudentErrorCode.EMAIL_SENDING_EXCEPTION); }
}
