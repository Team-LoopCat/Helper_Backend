package org.example.domain.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.student.exception.errorCode.StudentErrorCode;

public class GradeInfoNotExistsException extends GlobalBusinessException {
    public static GradeInfoNotExistsException EXCEPTION = new GradeInfoNotExistsException();

    public GradeInfoNotExistsException() { super(StudentErrorCode.GRADE_NOT_EXISTS); }
}
