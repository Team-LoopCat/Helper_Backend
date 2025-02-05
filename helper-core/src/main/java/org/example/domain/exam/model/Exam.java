package org.example.domain.exam.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Major;

@Getter
@Builder
@RequiredArgsConstructor
public class Exam {

    private final UUID examId;

    private final Major major;

    private final String grade;
}
