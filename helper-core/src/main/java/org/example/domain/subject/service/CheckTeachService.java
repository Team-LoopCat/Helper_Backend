package org.example.domain.subject.service;

import org.example.domain.subject.model.Subject;
import org.example.domain.teacher.model.Teacher;

public interface CheckTeachService {

    void checkTeacherTeachesSubject(Teacher teacher, Subject subject);
}
