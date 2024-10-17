package org.example.persistence.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.persistence.student.exception.errorCode.StudentPersistenceErrorCode;

public class UserNotExistsException extends GlobalBusinessException {
    public static final UserNotExistsException EXCEPTION = new UserNotExistsException();

    public UserNotExistsException() { super(StudentPersistenceErrorCode.USER_NOT_EXISTS); }
}
