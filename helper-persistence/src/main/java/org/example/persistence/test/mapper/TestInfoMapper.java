package org.example.persistence.test.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.test.model.TestInfo;
import org.example.persistence.GenericMapper;
import org.example.persistence.subject.entity.AttendJpaEntity;
import org.example.persistence.subject.repository.AttendJpaRepository;
import org.example.persistence.test.entity.TestInfoJpaEntity;
import org.example.persistence.test.entity.TestJpaEntity;
import org.example.persistence.test.repository.TestJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestInfoMapper implements GenericMapper<TestInfo, TestInfoJpaEntity> {
    private final AttendJpaRepository attendJpaRepository;
    private final TestJpaRepository testJpaRepository;

    @Override
    public Optional<TestInfo> toDomain(Optional<TestInfoJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        TestInfoJpaEntity testInfoEntity = entity.get();

        return Optional.of(new TestInfo(
                testInfoEntity.getAttend().getAttendId(),
                testInfoEntity.getTest().getTestId(),
                testInfoEntity.getEndDate()
        ));
    }

    @Override
    public TestInfoJpaEntity toEntity(TestInfo entity) {
        AttendJpaEntity attendJpaEntity = attendJpaRepository.findById
                (entity.getAttendId()).orElse(null);

        TestJpaEntity testJpaEntity = testJpaRepository.findById
                (entity.getTestId()).orElse(null);

        return new TestInfoJpaEntity(
                attendJpaEntity,
                testJpaEntity,
                entity.getEndDate()
        );
    }
}
