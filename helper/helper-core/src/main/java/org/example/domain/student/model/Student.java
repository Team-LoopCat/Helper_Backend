package org.example.domain.student.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.auth.model.Role;

import java.util.Optional;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Student {
    private final String studentId;

    private final String grade;

    private final String classroom;

    private final Optional<UUID> subjectId;

    private final String userId;

    private final String nickname;

    private final String profile;

    private final String email;

    private final Role role;
}
