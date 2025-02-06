package org.example.persistence.test;

import lombok.RequiredArgsConstructor;
import org.example.domain.test.model.TestInfo;
import org.example.domain.test.spi.QueryTestInfoPort;
import org.example.persistence.test.mapper.TestInfoMapper;
import org.example.persistence.test.repository.TestInfoJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestInfoPersistenceAdapter implements QueryTestInfoPort {
    private final TestInfoJpaRepository testInfoJpaRepository;
    private final TestInfoMapper testInfoMapper;

    @Override
    public void saveTestInfo(TestInfo testInfo) {
        testInfoJpaRepository.save(
                testInfoMapper.toEntity(testInfo)
        );
    }
}
