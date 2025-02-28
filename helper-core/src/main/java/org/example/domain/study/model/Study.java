package org.example.domain.study.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Study {

    private final UUID studyId;

    private final String studentId;

    private final UUID subjectId;

    private final String title;

    private final String content;

    private final String location;

    private final String date;

    private final String end;

    private final Category category;
}
