package org.example.persistence.exam.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.model.ExamData;
import org.example.persistence.GenericMapper;
import org.example.persistence.exam.entity.ExamDataJpaEntity;
import org.example.persistence.exam.entity.ExamJpaEntity;
import org.example.persistence.exam.repository.ExamJpaRepository;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.example.persistence.subject.repository.SubjectJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamDataMapper implements GenericMapper<ExamData, ExamDataJpaEntity> {
    private final ExamJpaRepository examJpaRepository;
    private final SubjectJpaRepository subjectJpaRepository;

    @Override
    public Optional<ExamData> toDomain(Optional<ExamDataJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        ExamDataJpaEntity examDataJpaEntity = entity.get();

        return Optional.of(new ExamData(
                examDataJpaEntity.getExamDataId(),
                examDataJpaEntity.getExam().getExamId(),
                examDataJpaEntity.getSubject().getSubjectId(),
                examDataJpaEntity.getDate(),
                examDataJpaEntity.getPeriod(),
                examDataJpaEntity.getProblems(),
                examDataJpaEntity.getPercent(),
                examDataJpaEntity.getContent()
        ));
    }

    @Override
    public ExamDataJpaEntity toEntity(ExamData entity) {
        ExamJpaEntity examJpaEntity = examJpaRepository.findById
                (entity.getSubjectId()).orElse(null);

        SubjectJpaEntity subjectJpaEntity = subjectJpaRepository.findById
                (entity.getSubjectId()).orElse(null);

        return new ExamDataJpaEntity(
                entity.getExamDataId(),
                examJpaEntity,
                subjectJpaEntity,
                entity.getDate(),
                entity.getPeriod(),
                entity.getProblems(),
                entity.getPercent(),
                entity.getContent()
        );
    }
}
