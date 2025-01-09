package org.example.domain.study.service;

import org.example.domain.student.model.Student;
import org.example.domain.study.model.Study;

public interface CheckStudyService {

    void checkStudyIsOwn(Study study, Student student);
}
