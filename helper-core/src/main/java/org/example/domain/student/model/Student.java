package org.example.domain.student.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

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
