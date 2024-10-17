package org.example.domain.teacher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.example.domain.auth.model.Role;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Teacher {
    private final UUID teacherId;

    private final String userId;

    private final String name;
}
