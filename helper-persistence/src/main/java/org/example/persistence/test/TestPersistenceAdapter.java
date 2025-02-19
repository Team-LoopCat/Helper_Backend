package org.example.persistence.test;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.model.Subject;
import org.example.domain.test.model.Test;
import org.example.domain.test.spi.QueryTestPort;
import org.example.domain.test.spi.vo.TestListDataVO;
import org.example.persistence.subject.mapper.SubjectMapper;
import org.example.persistence.test.mapper.TestMapper;
import org.example.persistence.test.repository.TestJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TestPersistenceAdapter implements QueryTestPort {
    private final TestJpaRepository testJpaRepository;
    private final TestMapper testMapper;
    private final SubjectMapper subjectMapper;

    @Override
    public Test saveTest(Test test) {
        return testMapper.toDomain(
            Optional.of(testJpaRepository.save(
                    testMapper.toEntity(test)
            ))
        ).get();
    }

    @Override
    public Optional<Test> getTestById(UUID testId) {
        return testMapper.toDomain(
                testJpaRepository.findById(testId)
        );
    }

    @Override
    public void deleteTest(Test test) {
        testJpaRepository.delete(
                testMapper.toEntity(test)
        );
    }

    @Override
    public List<TestListDataVO> getTestListDataBySubjectId(UUID subjectId) {
        return testJpaRepository.findTestListDataBySubjectId(subjectId);
    }
}
