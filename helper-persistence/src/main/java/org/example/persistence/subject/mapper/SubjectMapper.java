package org.example.persistence.subject.mapper;

import java.util.Optional;
import org.example.domain.subject.model.Subject;
import org.example.persistence.GenericMapper;
import org.example.persistence.subject.entity.SubjectJpaEntity;

public class SubjectMapper implements GenericMapper<Subject, SubjectJpaEntity> {

    @Override
    public Optional<Subject> toDomain(Optional<SubjectJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        SubjectJpaEntity subjectJpaEntity = entity.get();

        return Optional.of(new Subject(
                subjectJpaEntity.getSubjectId(),
                subjectJpaEntity.getName(),
                subjectJpaEntity.getOptional()
        ));
    }

    @Override
    public SubjectJpaEntity toEntity(Subject entity) {
        return new SubjectJpaEntity(
                entity.getSubjectId(),
                entity.getName(),
                entity.getOptional()
        );
    }
}
