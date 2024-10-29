package org.example.domain.subject.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Attend {

    private final UUID attendId;

    private final String grade;

    private final String classroom;

    private final UUID subjectId;
}
