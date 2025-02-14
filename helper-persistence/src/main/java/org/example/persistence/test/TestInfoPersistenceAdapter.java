package org.example.persistence.test;

import lombok.RequiredArgsConstructor;
import org.example.domain.test.model.Test;
import org.example.domain.test.model.TestInfo;
import org.example.domain.test.spi.QueryTestInfoPort;
import org.example.persistence.test.mapper.TestInfoMapper;
import org.example.persistence.test.mapper.TestMapper;
import org.example.persistence.test.repository.TestInfoJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestInfoPersistenceAdapter implements QueryTestInfoPort {
    private final TestInfoJpaRepository testInfoJpaRepository;
    private final TestInfoMapper testInfoMapper;
    private final TestMapper testMapper;

    @Override
    public void saveTestInfo(TestInfo testInfo) {
        testInfoJpaRepository.save(
                testInfoMapper.toEntity(testInfo)
        );
    }

    @Override
    public void deleteAllByTest(Test test) {
        testInfoJpaRepository.deleteAllByTest(
                testMapper.toEntity(test)
        );
    }
}
