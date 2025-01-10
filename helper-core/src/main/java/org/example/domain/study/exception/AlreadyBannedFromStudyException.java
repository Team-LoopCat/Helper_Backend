package org.example.domain.study.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.study.exception.errorCode.StudyErrorCode;

public class AlreadyBannedFromStudyException extends GlobalBusinessException {
    public static final AlreadyBannedFromStudyException EXCEPTION = new AlreadyBannedFromStudyException();

    public AlreadyBannedFromStudyException() { super(StudyErrorCode.ALREADY_BANNED_FROM_STUDY); }
}
