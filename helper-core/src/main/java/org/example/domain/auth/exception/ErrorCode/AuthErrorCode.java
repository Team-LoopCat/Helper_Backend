package org.example.domain.auth.exception.ErrorCode;

import lombok.RequiredArgsConstructor;
import org.example.common.exception.GlobalErrorCode;

public class AuthErrorCode extends GlobalErrorCode {
    public static AuthErrorCode PASSWORD_MISMATCHES() {
        return new AuthErrorCode(403, "비밀번호가 일치하지 않습니다");
    }

    public static AuthErrorCode USER_NOT_FOUND() {
        return new AuthErrorCode(404, "유저를 찾을 수 없습니다");
    }

    public AuthErrorCode(int ErrorStatus, String ErrorMessage) {
        super(ErrorStatus, ErrorMessage);
    }
}
