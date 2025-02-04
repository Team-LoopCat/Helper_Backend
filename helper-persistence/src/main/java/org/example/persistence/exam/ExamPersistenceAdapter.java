package org.example.persistence.exam;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.spi.QueryExamPort;
import org.example.persistence.exam.mapper.ExamDataMapper;
import org.example.persistence.exam.mapper.ExamMapper;
import org.example.persistence.exam.repository.ExamDataJpaRepository;
import org.example.persistence.exam.repository.ExamJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamPersistenceAdapter implements QueryExamPort {
    private final ExamJpaRepository examJpaRepository;
    private final ExamDataJpaRepository examDataJpaRepository;
    private final ExamMapper examMapper;
    private final ExamDataMapper examDataMapper;

    @Override
    public boolean existsAnyExam() {
        return examJpaRepository.existsBy();
    }

    @Override
    public Exam saveExam(Exam exam) {
        return examMapper.toDomain(
                Optional.of(examJpaRepository.save(
                        examMapper.toEntity(exam)
                ))
        ).get();
    }

    @Override
    public List<ExamData> saveAllExamData(List<ExamData> examData) {
        return examDataJpaRepository.saveAll(
                examData.stream().map(examDataMapper::toEntity).toList()
        ).stream().map(entity ->
            examDataMapper.toDomain(
                    Optional.of(entity)
            ).get()
        ).toList();
    }
}
