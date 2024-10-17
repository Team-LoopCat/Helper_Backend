package org.example.persistence.student.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.persistence.student.exception.errorCode.StudentPersistenceErrorCode;

public class GradeOrClassroomNotFoundException extends GlobalBusinessException {
    public static final GradeOrClassroomNotFoundException EXCEPTION = new GradeOrClassroomNotFoundException();

    public GradeOrClassroomNotFoundException() { super(StudentPersistenceErrorCode.GRADE_OR_CLASSROOM_NOT_EXISTS); }
}
