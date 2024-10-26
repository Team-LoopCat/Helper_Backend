package org.example.global.thirdparty.S3.execption.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum S3ErrorCode implements GlobalErrorCode {
    FILE_UPLOAD_FAILED(500, "파일 업로드가 어떠한 이유에 의해 실패했습니다");

    private final int errorStatus;
    private final String errorMessage;

    @Override
    public int getErrorStatus() {
        return 0;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
