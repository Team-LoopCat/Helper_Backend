package org.example.persistence.test.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.test.model.Test;
import org.example.persistence.GenericMapper;
import org.example.persistence.test.entity.TestJpaEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestMapper implements GenericMapper<Test, TestJpaEntity> {

    @Override
    public Optional<Test> toDomain(Optional<TestJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        TestJpaEntity jpaEntity = entity.get();

        return Optional.of(new Test(
                jpaEntity.getTestId(),
                jpaEntity.getTitle(),
                jpaEntity.getContent(),
                jpaEntity.getPercent(),
                jpaEntity.getFile()
        ));
    }

    @Override
    public TestJpaEntity toEntity(Test entity) {
        return new TestJpaEntity(
                entity.getTestId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getPercent(),
                entity.getFile()
        );
    }
}
