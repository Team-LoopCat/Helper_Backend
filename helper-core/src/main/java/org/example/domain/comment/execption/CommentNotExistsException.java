package org.example.domain.comment.execption;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.comment.execption.errorCode.CommentErrorCode;

public class CommentNotExistsException extends GlobalBusinessException {
    public static final CommentNotExistsException EXCEPTION = new CommentNotExistsException();

    public CommentNotExistsException() { super(CommentErrorCode.COMMENT_NOT_EXISTS); }
}
