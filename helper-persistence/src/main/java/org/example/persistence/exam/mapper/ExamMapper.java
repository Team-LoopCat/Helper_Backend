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

        ExamJpaEntity examEntity = entity.get();

        return Optional.of(new Exam(
                examEntity.getExamId(),
                examEntity.getMajor(),
                examEntity.getGrade()
        ));
    }

    @Override
    public ExamJpaEntity toEntity(Exam entity) {
        return new ExamJpaEntity(
                entity.getExamId(),
                entity.getMajor(),
                entity.getGrade()
        );
    }
}
