package org.example.domain.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.student.exception.errorCode.StudentErrorCode;

public class StudentNumberAlreadyExistsException extends GlobalBusinessException {
    public static final StudentNumberAlreadyExistsException EXCEPTION = new StudentNumberAlreadyExistsException();

    public StudentNumberAlreadyExistsException() { super(StudentErrorCode.STUDENT_NUMBER_ALREADY_EXISTS); }
}
