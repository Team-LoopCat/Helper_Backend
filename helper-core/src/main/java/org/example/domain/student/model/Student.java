package org.example.domain.student.model;

import java.util.Optional;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Student {

    private final String studentId;

    private final String grade;

    private final String classroom;

    private final Optional<UUID> subjectId;

    private final String userId;

    private final String nickname;

    private final String email;
}
