package org.example.domain.subject.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.subject.exception.errorCode.AttendErrorCode;

public class AttendDataNotFoundException extends GlobalBusinessException {
    public static final AttendDataNotFoundException EXCEPTION = new AttendDataNotFoundException();

    public AttendDataNotFoundException() { super(AttendErrorCode.SUBJECT_NOT_FOUND); }
}
