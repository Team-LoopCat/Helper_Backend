package org.example.domain.test.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Test {

    private final UUID testId;

    private final UUID subjectId;

    private final String title;

    private final String content;

    private final Integer percent;
}
