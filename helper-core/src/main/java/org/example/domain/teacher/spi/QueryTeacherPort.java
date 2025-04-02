package org.example.domain.teacher.spi;

import org.example.domain.teacher.model.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QueryTeacherPort {

    Teacher saveTeacher(Teacher teacher);

    Optional<Teacher> queryTeacherByUserId(String id);

    List<String> queryTeacherBySubjectId(UUID subjectId);
}
