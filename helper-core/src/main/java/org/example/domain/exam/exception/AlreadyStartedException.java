package org.example.domain.exam.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.exam.exception.ErrorCode.ExamErrorCode;

public class AlreadyStartedException extends GlobalBusinessException {
    public static final AlreadyStartedException EXCEPTION = new AlreadyStartedException();

    public AlreadyStartedException() { super(ExamErrorCode.ALREADY_STARTED); }
}
