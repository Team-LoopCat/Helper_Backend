package org.example.global.thirdparty.S3.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.global.thirdparty.S3.exception.errorCode.S3ErrorCode;

public class FileUploadException extends GlobalBusinessException {
    public static final FileUploadException EXCEPTION = new FileUploadException();

    public FileUploadException() { super(S3ErrorCode.FILE_UPLOAD_EXCEPTION); }
}
