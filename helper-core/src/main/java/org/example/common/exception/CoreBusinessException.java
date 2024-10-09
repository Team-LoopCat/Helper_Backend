package org.example.common.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CoreBusinessException extends RuntimeException {
    public final GlobalErrorCode errorCode;
}
