package org.example.persistence.exam.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.model.Exam;
import org.example.persistence.GenericMapper;
import org.example.persistence.exam.entity.ExamJpaEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamMapper implements GenericMapper<Exam, ExamJpaEntity> {

    @Override
    public Optional<Exam> toDomain(Optional<ExamJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        ExamJpaEntity examJpaEntity = entity.get();

        return Optional.of(new Exam(
                examJpaEntity.getExamId(),
                examJpaEntity.getStart(),
                examJpaEntity.getEnd(),
                examJpaEntity.getName(),
                examJpaEntity.getDeadline()
        ));
    }

    @Override
    public ExamJpaEntity toEntity(Exam entity) {
        return new ExamJpaEntity(
                entity.getExamId(),
                entity.getStart(),
                entity.getEnd(),
                entity.getName(),
                entity.getDeadline()
        );
    }
}
