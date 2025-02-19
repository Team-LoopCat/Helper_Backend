package org.example.domain.exam.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.exam.exception.ErrorCode.ExamErrorCode;

public class DuplicateDateOrPeriodException extends GlobalBusinessException {
    public static final DuplicateDateOrPeriodException EXCEPTION = new DuplicateDateOrPeriodException();

    public DuplicateDateOrPeriodException() { super(ExamErrorCode.DUPLICATE_DATE_OR_PERIOD); }
}

