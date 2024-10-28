package org.example.domain.test.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Test {

    private final UUID testId;

    private final String title;

    private final String content;

    private final Integer percent;

    private final String file;
}
