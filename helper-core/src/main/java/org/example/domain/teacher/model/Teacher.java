package org.example.domain.teacher.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Teacher {

    private final UUID teacherId;

    private final String userId;

    private final String name;

    private final Role role;
}
