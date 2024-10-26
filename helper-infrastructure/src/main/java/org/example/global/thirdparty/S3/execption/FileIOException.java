package org.example.global.thirdparty.S3.execption;

import org.example.common.exception.GlobalBusinessException;
import org.example.global.thirdparty.S3.execption.errorCode.S3ErrorCode;

public class FileIOException extends GlobalBusinessException {
    public static final FileIOException EXCEPTION = new FileIOException();

    public FileIOException() { super(S3ErrorCode.FILE_UPLOAD_FAILED); }
}
