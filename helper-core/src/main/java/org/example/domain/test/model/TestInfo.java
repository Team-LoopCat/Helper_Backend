package org.example.domain.test.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestInfo {

    private final UUID attendId;

    private final UUID testId;

    private final LocalDate endDate;
}
