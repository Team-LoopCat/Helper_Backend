package org.example.domain.comment.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum ReplyErrorCode implements GlobalErrorCode {
    IS_NOT_OWNER_OF_REPLY(403, "권한이 없는 대댓글을 수정/삭제 시도하였습니다"),
    REPLY_NOT_FOUND(404, "대댓글을 찾을 수 없습니다");


    final int errorStatus;
    final String errorMessage;

    @Override
    public int getErrorStatus() {
        return errorStatus;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
