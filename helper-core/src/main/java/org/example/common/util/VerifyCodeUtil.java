package org.example.common.util;

import org.example.domain.student.exception.CodeNotExistsInRedisException;
import org.example.domain.student.exception.VerifyCodeNotMatchesException;

import java.util.Random;

public final class VerifyCodeUtil {

    public static String createRandomCode() {
        Random random = new Random();
        StringBuilder randomNumber = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10);
            randomNumber.append(digit);
        }

        return randomNumber.toString();
    }


    public static void checkCodeMatches(String generatedCode, String RequestCode) {
        if (!generatedCode.equals(RequestCode)) {
            throw VerifyCodeNotMatchesException.EXCEPTION;
        }
    }
}
