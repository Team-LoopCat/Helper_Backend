package org.example.common.util;

public final class StudentNumberUtil {

    public static String combination(String grade, String classroom, String number) {
        return grade + classroom + String.format("%02d", Integer.parseInt(number));
    }
}
