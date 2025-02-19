package org.example.persistence.subject;

import java.util.Optional;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.subject.spi.QuerySubjectPort;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;
import org.example.domain.subject.model.Subject;
import org.example.domain.teacher.model.Teacher;
import org.example.persistence.subject.mapper.SubjectMapper;
import org.example.persistence.subject.repository.SubjectJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectPersistenceAdapter implements QuerySubjectPort {
    private final SubjectJpaRepository subjectJpaRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public List<SubjectAndAttendVO> getSubjectsAndAttendsByTeacherId(UUID teacherId) {
        return subjectJpaRepository.findAllByTeachTeacherId(teacherId);
    }

    @Override
    public Optional<Subject> getSubjectById(UUID subjectId) {
        return subjectMapper.toDomain(
                subjectJpaRepository.findBySubjectId(subjectId)
        );
    }

    @Override
    public List<Subject> getSubjectsByTeacher(UUID teacherId) {
        return subjectJpaRepository.findAllByTeacher(teacherId);
    }
}
