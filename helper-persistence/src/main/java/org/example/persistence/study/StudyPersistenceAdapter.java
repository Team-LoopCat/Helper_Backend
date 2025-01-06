package org.example.persistence.study;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.model.Category;
import org.example.domain.study.model.Study;
import org.example.domain.study.spi.QueryStudyPort;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;
import org.example.persistence.study.mapper.StudyMapper;
import org.example.persistence.study.repository.StudyJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudyPersistenceAdapter implements QueryStudyPort {
    private final StudyJpaRepository studyJpaRepository;
    private final StudyMapper studyMapper;

    @Override
    public Optional<Study> findByStudyId(UUID studyId) {
        return studyMapper.toDomain(
                studyJpaRepository.findById(studyId)
        );
    }

    @Override
    public Study saveStudy(Study study) {
        return studyMapper.toDomain(
                Optional.of(studyJpaRepository.save(
                        studyMapper.toEntity(study)
                ))
        ).get();
    }

    @Override
    public void deleteStudyByStudyId(UUID studyId) {
        studyJpaRepository.deleteById(studyId);
    }

    @Override
    public List<StudyWithMemberCountVO> findAllWithCount() {
        return studyJpaRepository.findAllWithCount();
    }

    @Override
    public List<StudyWithMemberCountVO> findAllByCategory(Category category) {
        return studyJpaRepository.findAllByCategoryWithCount(category);
    }
}
