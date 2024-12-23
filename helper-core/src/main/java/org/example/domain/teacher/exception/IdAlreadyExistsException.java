package org.example.domain.teacher.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.teacher.exception.ErrorCode.TeacherErrorCode;

public class IdAlreadyExistsException extends GlobalBusinessException {
    public static final IdAlreadyExistsException EXCEPTION = new IdAlreadyExistsException();

    public IdAlreadyExistsException() { super(TeacherErrorCode.ID_ALREADY_EXIST); }
}
