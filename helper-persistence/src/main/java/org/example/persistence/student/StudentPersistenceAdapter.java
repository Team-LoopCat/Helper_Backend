package org.example.persistence.student;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.domain.student.spi.QueryStudentPort;
import org.example.persistence.student.mapper.StudentMapper;
import org.example.persistence.student.repository.StudentJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements QueryStudentPort {
    private final StudentJpaRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public Boolean checkStudentExistsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    @Override
    public Boolean checkStudentExistsByStudentNum(String studentNum) {
        return studentRepository.existsByStudentId(studentNum);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(
                studentMapper.toEntity(student)
        );
    }
}
