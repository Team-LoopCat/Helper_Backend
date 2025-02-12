package org.example.domain.subject.spi;

import org.example.domain.subject.model.Subject;
import org.example.domain.teacher.model.Teacher;

public interface QueryTeachPort {

    Boolean existByTeacherAndSubject(Teacher teacher, Subject subject);
}
