package org.example.domain.study.service;

import org.example.domain.student.model.Student;
import org.example.domain.study.model.Study;

public interface CheckMemberService {

    void checkJoinAvailable(Study study, Student student);
}
