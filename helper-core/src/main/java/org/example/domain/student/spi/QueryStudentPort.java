package org.example.domain.student.spi;

import org.example.domain.auth.model.User;
import org.example.domain.student.model.Student;

import java.util.Optional;

public interface QueryStudentPort {

    Boolean checkStudentExistsByEmail(String email);

    Boolean checkStudentExistsByStudentNum(String studentNum);

    void saveStudent(Student student);

    Optional<Student> getStudentByUserId(User user);

    Optional<Student> getStudentByStudentId(String studentId);
}
