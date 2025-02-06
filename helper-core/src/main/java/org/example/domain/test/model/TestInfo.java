package org.example.domain.test.model;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class TestInfo {

    private final UUID attendId;

    private final UUID testId;

    private final LocalDate endDate;
}
