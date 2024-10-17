package org.example.common.util;

import org.springframework.stereotype.Component;

@Component
public class StudentNumberUtil {

    public String combination(String grade, String classroom, String number) {
        return grade + classroom + String.format("%02d", Integer.parseInt(number));
    }
}
