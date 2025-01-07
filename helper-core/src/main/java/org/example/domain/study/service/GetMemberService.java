package org.example.domain.study.service;

import java.util.UUID;
import org.example.domain.student.model.Student;
import org.example.domain.study.model.Member;
import org.example.domain.study.model.Study;

public interface GetMemberService {

    Member getByStudyAndStudent(Study study, Student student);
}
