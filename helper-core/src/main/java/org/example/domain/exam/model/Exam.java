package org.example.domain.exam.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Exam {

    private final UUID examId;

    private final LocalDate start;

    private final LocalDate end;

    private final String name;

    private final LocalDate deadline;
}
