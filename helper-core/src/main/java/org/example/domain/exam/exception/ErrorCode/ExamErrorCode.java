package org.example.domain.exam.exception.ErrorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum ExamErrorCode implements GlobalErrorCode {
    EXAM_DATA_NOT_FOUND(404, "존재하지 않는 시험 정보 입니다"),
    ALREADY_STARTED(409, "이미 시험이 시작되었습니다"),
    DUPLICATE_DATE_AND_PERIOD(409, "이미 존재하는 시험 날짜 및 교시입니다");

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
