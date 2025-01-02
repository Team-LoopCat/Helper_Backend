package org.example.global.thirdparty.S3.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum S3ErrorCode implements GlobalErrorCode {
    FILE_UPLOAD_EXCEPTION(500, "파일 업로드에 실패했습니다.");

    private final int errorCode;
    private final String errorMessage;

    @Override
    public int getErrorStatus() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
