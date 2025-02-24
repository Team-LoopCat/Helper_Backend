package org.example.domain.exam.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.exam.exception.ErrorCode.ExamErrorCode;

public class DuplicateDateAndPeriodException extends GlobalBusinessException {
    public static final DuplicateDateAndPeriodException EXCEPTION = new DuplicateDateAndPeriodException();

    public DuplicateDateAndPeriodException() { super(ExamErrorCode.DUPLICATE_DATE_AND_PERIOD); }
}

