package org.example.domain.teacher.spi;

import org.example.domain.teacher.model.Teacher;

import java.util.Optional;

public interface QueryTeacherPort {

    Optional<Teacher> queryTeacherById(String id);

    Boolean checkTeacherId(String id);
}
