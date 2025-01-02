package org.example.domain.study.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.study.exception.errorCode.StudyErrorCode;

public class NotOwnStudyException extends GlobalBusinessException {
    public static final NotOwnStudyException EXCEPTION = new NotOwnStudyException();

    public NotOwnStudyException() { super(StudyErrorCode.NOT_OWN_STUDY); }
}
