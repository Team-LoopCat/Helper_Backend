package org.example.persistence.test;

import lombok.RequiredArgsConstructor;
import org.example.domain.test.model.Test;
import org.example.domain.test.spi.QueryTestPort;
import org.example.persistence.test.mapper.TestMapper;
import org.example.persistence.test.repository.TestJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TestPersistenceAdapter implements QueryTestPort {
    private final TestJpaRepository testJpaRepository;
    private final TestMapper testMapper;

    @Override
    public Test saveTest(Test test) {
        return testMapper.toDomain(
            Optional.of(testJpaRepository.save(
                    testMapper.toEntity(test)
            ))
        ).get();
    }

}
