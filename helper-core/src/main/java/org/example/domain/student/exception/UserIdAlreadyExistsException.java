package org.example.domain.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.student.exception.errorCode.StudentErrorCode;

public class UserIdAlreadyExistsException extends GlobalBusinessException {
    public static final UserIdAlreadyExistsException EXCEPTION = new UserIdAlreadyExistsException();

    public UserIdAlreadyExistsException() { super(StudentErrorCode.USER_ID_ALREADY_EXISTS); }
}
