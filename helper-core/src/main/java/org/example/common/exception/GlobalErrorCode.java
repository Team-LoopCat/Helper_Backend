package org.example.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface GlobalErrorCode {
    int getErrorStatus();
    String getErrorMessage();
}
