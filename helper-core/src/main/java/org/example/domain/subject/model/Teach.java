package org.example.domain.subject.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Teach {

    private final UUID teacherId;

    private final UUID subjectId;
}
