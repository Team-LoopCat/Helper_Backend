package org.example.domain.comment.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.comment.exception.errorCode.ReplyErrorCode;

public class ReplyNotFoundException extends GlobalBusinessException {
    public static final ReplyNotFoundException EXCEPTION = new ReplyNotFoundException();

    public ReplyNotFoundException() { super(ReplyErrorCode.REPLY_NOT_FOUND); }
}
