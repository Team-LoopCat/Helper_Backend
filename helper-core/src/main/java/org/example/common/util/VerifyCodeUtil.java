package org.example.common.util;

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
}
