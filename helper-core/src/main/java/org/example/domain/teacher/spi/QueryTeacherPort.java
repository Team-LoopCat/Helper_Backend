package org.example.domain.teacher.spi;

import org.example.domain.teacher.model.Teacher;

import java.util.Optional;
import java.util.UUID;

public interface QueryTeacherPort {

    Optional<Teacher> queryUserById(UUID teacherId);

    Boolean checkTeacherId(String id);
}
