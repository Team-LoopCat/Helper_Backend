package org.example.domain.study.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.study.exception.errorCode.StudyErrorCode;

public class MemberNotFoundException extends GlobalBusinessException {
    public static final MemberNotFoundException EXCEPTION = new MemberNotFoundException();

    public MemberNotFoundException() { super(StudyErrorCode.MEMBER_NOT_FOUND); }
}
