package org.example.domain.exam.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExamData {

    private final UUID examDataId;

    private final UUID examId;

    private final UUID subjectId;

    private final LocalDate date;

    private final Integer period;

    private final Integer problems;

    private final Integer percent;

    private final String content;
}
