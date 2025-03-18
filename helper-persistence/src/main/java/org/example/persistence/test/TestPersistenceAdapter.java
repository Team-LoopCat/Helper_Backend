package org.example.persistence.test;

import lombok.RequiredArgsConstructor;
import org.example.domain.test.model.Test;
import org.example.domain.test.spi.QueryTestPort;
import org.example.domain.test.spi.vo.TestListDataForStudentVO;
import org.example.domain.test.spi.vo.TestListDataForTeacherVO;
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
    public List<TestListDataForTeacherVO> getTestListDataForTeacherBySubjectId(UUID subjectId) {
        return testJpaRepository.findTestListDataForTeacherBySubjectId(subjectId);
    }

    @Override
    public List<TestListDataForStudentVO> getTestDataListForStudentByGradeAndClassroom(String grade, String classroom) {
        return testJpaRepository.findStudentTestListDataByGradeAndClassroom(grade, classroom);
    }

    @Override
    public TestListDataForStudentVO getTestDataForStudentBySubjectId(UUID subjectId) {
        return testJpaRepository.findTestDataForStudentBySubjectId(subjectId);
    }
}
