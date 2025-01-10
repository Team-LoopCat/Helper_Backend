package org.example.domain.study.service;

import java.util.List;
import java.util.UUID;
import org.example.domain.student.model.Student;
import org.example.domain.study.model.Member;
import org.example.domain.study.model.Study;

public interface GetMemberService {

    Member getByStudyAndStudent(Study study, Student student);

    List<Student> getAllStudentByStudy(Study study);
}
