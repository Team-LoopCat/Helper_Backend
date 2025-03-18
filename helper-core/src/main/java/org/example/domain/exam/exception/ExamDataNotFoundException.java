package org.example.domain.exam.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.exam.exception.ErrorCode.ExamErrorCode;

public class ExamDataNotFoundException extends GlobalBusinessException {
    public static final ExamDataNotFoundException EXCEPTION = new ExamDataNotFoundException();

    public ExamDataNotFoundException() { super(ExamErrorCode.EXAM_DATA_NOT_FOUND); }
}
