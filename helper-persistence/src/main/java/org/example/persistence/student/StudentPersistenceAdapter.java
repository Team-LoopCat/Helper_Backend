package org.example.persistence.student;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.domain.student.spi.QueryStudentPort;
import org.example.persistence.student.mapper.StudentMapper;
import org.example.persistence.student.repository.StudentJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements QueryStudentPort {
    private final StudentJpaRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public Optional<Student> queryUserByEmail(String email) {
        return studentMapper.toDomain(
                studentRepository.findByEmail(email)
        );
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(
                studentMapper.toEntity(student)
        );
    }
}
