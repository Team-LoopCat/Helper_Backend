package org.example.domain.student.spi;

import org.example.domain.student.model.Student;

import java.util.Optional;

public interface QueryStudentPort {

    Boolean checkStudentExistsByEmail(String email);

    void saveStudent(Student student);
}
