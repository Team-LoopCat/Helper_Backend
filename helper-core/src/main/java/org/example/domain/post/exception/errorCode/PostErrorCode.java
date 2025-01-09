package org.example.domain.post.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum PostErrorCode implements GlobalErrorCode {
    IS_NOT_WRITER(403, "게시글의 작성자가 아닙니다"),
    POST_NOT_FOUND(404, "존재하지 않는 게시글입니다");

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
