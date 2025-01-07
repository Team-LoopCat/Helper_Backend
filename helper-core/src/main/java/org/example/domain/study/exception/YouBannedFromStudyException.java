package org.example.domain.study.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.study.exception.errorCode.StudyErrorCode;

public class YouBannedFromStudyException extends GlobalBusinessException {
    public static final YouBannedFromStudyException EXCEPTION = new YouBannedFromStudyException();

    public YouBannedFromStudyException() { super(StudyErrorCode.YOU_BANNED_FROM_STUDY); }
}
