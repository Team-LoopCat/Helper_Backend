package org.example.domain.student.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GradeInfo {

    private final String grade;

    private final String classroom;

    private final Major major;
}
