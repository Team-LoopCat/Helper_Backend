package org.example.persistence.test.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.test.model.Test;
import org.example.persistence.GenericMapper;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.example.persistence.subject.repository.SubjectJpaRepository;
import org.example.persistence.test.entity.TestJpaEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestMapper implements GenericMapper<Test, TestJpaEntity> {
    private final SubjectJpaRepository subjectJpaRepository;

    @Override
    public Optional<Test> toDomain(Optional<TestJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        TestJpaEntity testEntity = entity.get();

        return Optional.of(new Test(
                testEntity.getTestId(),
                testEntity.getSubject().getSubjectId(),
                testEntity.getTitle(),
                testEntity.getContent(),
                testEntity.getPercent()
        ));
    }

    @Override
    public TestJpaEntity toEntity(Test entity) {
        SubjectJpaEntity subjectJpaEntity = subjectJpaRepository.findById
                (entity.getSubjectId()).orElse(null);

        return new TestJpaEntity(
                entity.getTestId(),
                subjectJpaEntity,
                entity.getTitle(),
                entity.getContent(),
                entity.getPercent()
        );
    }
}
