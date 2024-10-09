package org.example.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GlobalErrorCode {
    private final int ErrorStatus;
    private final String ErrorMessage;
}
