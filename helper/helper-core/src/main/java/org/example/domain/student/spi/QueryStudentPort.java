package org.example.domain.student.spi;

import org.example.domain.student.model.Student;

import java.util.Optional;

public interface QueryStudentPort {
    public Optional<Student> queryUserById(String userId);
}
