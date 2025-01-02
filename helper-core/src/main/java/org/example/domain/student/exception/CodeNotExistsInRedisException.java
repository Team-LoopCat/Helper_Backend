package org.example.domain.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.student.exception.errorCode.StudentErrorCode;

public class CodeNotExistsInRedisException extends GlobalBusinessException {
    public static final CodeNotExistsInRedisException EXCEPTION = new CodeNotExistsInRedisException();

    public CodeNotExistsInRedisException() { super(StudentErrorCode.CODE_NOT_EXISTS_IN_REDIS); }
}
