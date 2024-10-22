package org.example.domain.teacher.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.domain.auth.model.Role;

@Getter
@RequiredArgsConstructor
public class Teacher {

    private final UUID teacherId;

    private final String userId;

    private final String name;

    private final Role role;
}
