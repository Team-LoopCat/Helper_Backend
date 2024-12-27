package org.example.domain.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.student.exception.errorCode.StudentErrorCode;

public class StudentNotFoundException extends GlobalBusinessException {
    public static final StudentNotFoundException EXCEPTION = new StudentNotFoundException();

    public StudentNotFoundException() { super(StudentErrorCode.STUDENT_NOT_FOUND); }
}
