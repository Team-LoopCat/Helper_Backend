package org.example.domain.comment.execption;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.comment.execption.errorCode.CommentErrorCode;

public class IsNotOwnerOfCommentException extends GlobalBusinessException {
    public static final IsNotOwnerOfCommentException EXCEPTION = new IsNotOwnerOfCommentException();

    public IsNotOwnerOfCommentException() { super(CommentErrorCode.IS_NOT_OWNER_OF_COMMENT); }
}
