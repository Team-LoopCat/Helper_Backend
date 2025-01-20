package org.example.domain.exam.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Major;

@Getter
@RequiredArgsConstructor
public class Exam {

    private final UUID examId;

    private final LocalDate start;

    private final LocalDate end;

    private final Major major;

    private final String grade;

    private final LocalDate deadline;
}
