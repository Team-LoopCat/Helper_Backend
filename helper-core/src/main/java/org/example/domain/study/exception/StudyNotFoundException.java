package org.example.domain.study.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.study.exception.errorCode.StudyErrorCode;

public class StudyNotFoundException extends GlobalBusinessException {
    public static final StudyNotFoundException EXCEPTION = new StudyNotFoundException();

    public StudyNotFoundException() { super(StudyErrorCode.STUDY_NOT_FOUND); }
}
