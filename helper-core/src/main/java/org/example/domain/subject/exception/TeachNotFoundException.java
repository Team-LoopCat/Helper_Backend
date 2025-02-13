package org.example.domain.subject.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.subject.exception.errorCode.TeachErrorCode;

public class TeachNotFoundException extends GlobalBusinessException {
    public static final TeachNotFoundException EXCEPTION = new TeachNotFoundException();

    public TeachNotFoundException() { super(TeachErrorCode.TEACH_NOT_FOUND); }
}
