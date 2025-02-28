package org.example.persistence.teacher;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.teacher.model.Teacher;
import org.example.domain.teacher.spi.QueryTeacherPort;
import org.example.persistence.teacher.mapper.TeacherMapper;
import org.example.persistence.teacher.repository.TeacherJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherPersistenceAdapter implements QueryTeacherPort {
    private final TeacherMapper teacherMapper;
    private final TeacherJpaRepository teacherJpaRepository;

    @Override
    public Optional<Teacher> queryUserById(UUID teacherId) {
        return teacherMapper.toDomain(
                teacherJpaRepository.findByTeacherId(teacherId)
        );
    }
}
