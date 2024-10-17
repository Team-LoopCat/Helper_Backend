package org.example.domain.student.spi;

import org.example.domain.student.model.Student;

import java.util.Optional;

public interface QueryStudentPort {

    Optional<Student> queryUserByEmail (String email);

    void saveStudent(Student student);
}
