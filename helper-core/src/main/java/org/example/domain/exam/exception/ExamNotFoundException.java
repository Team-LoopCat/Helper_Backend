package org.example.domain.exam.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.exam.exception.ErrorCode.ExamErrorCode;

public class ExamNotFoundException extends GlobalBusinessException {
    public static final ExamNotFoundException EXCEPTION = new ExamNotFoundException();

    public ExamNotFoundException() { super(ExamErrorCode.EXAM_NOT_FOUND); }
}
