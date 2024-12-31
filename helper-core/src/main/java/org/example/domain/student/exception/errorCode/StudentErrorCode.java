package org.example.domain.student.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum StudentErrorCode implements GlobalErrorCode {
    EMAIL_NOT_VALID(400, "이메일이 유효하지 않습니다"),
    GRADE_NOT_EXISTS(404, "존재하지 않는 학년/반입니다"),
    STUDENT_NOT_FOUND(404, "존재하지 않는 학생입니다"),
    EMAIL_ALREADY_EXISTS(409, "이미 가입된 이메일입니다"),
    USER_ID_ALREADY_EXISTS(409, "이미 가입된 유저 아이디입니다"),
    STUDENT_NUMBER_ALREADY_EXISTS(409, "이미 가입된 학번입니다"),
    EMAIL_SENDING_EXCEPTION(500, "이메일을 보내는것을 실패했습니다");

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
