package org.example.domain.subject.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Subject {

    private final UUID subjectId;

    private final String name;

    private final Boolean optional;
}
