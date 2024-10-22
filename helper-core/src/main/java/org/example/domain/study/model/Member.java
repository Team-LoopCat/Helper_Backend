package org.example.domain.study.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Member {

    private final String studentId;

    private final UUID studyId;

    private final Boolean isBanned;
}
