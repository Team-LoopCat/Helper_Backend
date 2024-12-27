package org.example.domain.teacher.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.teacher.exception.ErrorCode.TeacherErrorCode;

public class TeacherNotFoundException extends GlobalBusinessException {
    public static final TeacherNotFoundException EXCEPTION = new TeacherNotFoundException();

    public TeacherNotFoundException() { super(TeacherErrorCode.TEACHER_NOT_FOUND); }
}
