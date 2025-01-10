package org.example.domain.study.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.study.exception.errorCode.StudyErrorCode;

public class AlreadyJoinedStudyException extends GlobalBusinessException {
    public static final AlreadyJoinedStudyException EXCEPTION = new AlreadyJoinedStudyException();

    public AlreadyJoinedStudyException() { super(StudyErrorCode.ALREADY_JOINED_STUDY); }
}
