package org.example.domain.study.exception.errorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

@RequiredArgsConstructor
public enum StudyErrorCode implements GlobalErrorCode {
    NOT_OWN_STUDY(403, "소유하지 않은 스터디입니다"),
    ALREADY_BANNED_FROM_STUDY(403, "이미 밴 당한 스터디입니다"),
    STUDY_NOT_FOUND(404, "존재하지 않는 스터디입니다"),
    MEMBER_NOT_FOUND(404, "존재하지 않는 멤버입니다"),
    ALREADY_JOINED_STUDY(409, "이미 참여한 스터디입니다");

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
