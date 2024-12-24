package org.example.persistence.subject;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.subject.spi.QuerySubjectPort;
import org.example.domain.subject.spi.vo.SubjectAndAttendVO;
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
}
