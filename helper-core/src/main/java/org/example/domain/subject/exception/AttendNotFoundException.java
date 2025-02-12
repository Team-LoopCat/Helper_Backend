package org.example.domain.subject.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.subject.exception.errorCode.AttendErrorCode;

public class AttendNotFoundException extends GlobalBusinessException {
    public static final AttendNotFoundException EXCEPTION = new AttendNotFoundException();

    public AttendNotFoundException() { super(AttendErrorCode.ATTEND_NOT_FOUND); }
}
