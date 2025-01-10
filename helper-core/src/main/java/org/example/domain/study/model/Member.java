package org.example.domain.study.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Member {

    private final String studentId;

    private final UUID studyId;

    private final Boolean isBanned;
}
