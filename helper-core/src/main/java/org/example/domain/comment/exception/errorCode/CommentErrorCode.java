package org.example.domain.comment.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum CommentErrorCode implements GlobalErrorCode {
    IS_NOT_OWNER_OF_COMMENT(403, "권한이 없는 댓글을 수정 시도하였습니다"),
    COMMENT_NOT_EXISTS(404, "존재하지 않는 댓글입니다");

    private final int errorStatus;
    private final String errorMessage;

    @Override
    public int getErrorStatus() {
        return errorStatus;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}