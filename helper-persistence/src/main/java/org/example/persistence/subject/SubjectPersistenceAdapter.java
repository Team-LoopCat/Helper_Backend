package org.example.persistence.subject;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.spi.QuerySubjectPort;
import org.example.persistence.subject.mapper.SubjectMapper;
import org.example.persistence.subject.repository.SubjectJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SubjectPersistenceAdapter implements QuerySubjectPort {
    private final SubjectJpaRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public Optional<Subject> getSubjectById(UUID subjectId) {
        return subjectMapper.toDomain(
                subjectRepository.findBySubjectId(subjectId)
        );
    }
}
