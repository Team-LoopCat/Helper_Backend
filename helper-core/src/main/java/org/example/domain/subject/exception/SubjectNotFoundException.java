package org.example.domain.subject.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.subject.exception.errorCode.SubjectErrorCode;

public class SubjectNotFoundException extends GlobalBusinessException {
    public static final SubjectNotFoundException EXCEPTION = new SubjectNotFoundException();

    public SubjectNotFoundException() { super(SubjectErrorCode.SUBJECT_NOT_FOUND); }
}
