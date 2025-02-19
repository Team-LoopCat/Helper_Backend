package org.example.persistence.exam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.spi.QueryExamDataPort;
import org.example.persistence.exam.mapper.ExamDataMapper;
import org.example.persistence.exam.repository.ExamDataJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamDataPersistenceAdapter implements QueryExamDataPort {
    private final ExamDataJpaRepository examDataJpaRepository;
    private final ExamDataMapper examDataMapper;

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

    @Override
    public ExamData saveExamData(ExamData examData) {
        return examDataMapper.toDomain(
                Optional.of(examDataJpaRepository.save(
                        examDataMapper.toEntity(examData)
                ))
        ).get();
    }

    @Override
    public Optional<ExamData> queryFirstExamDataOrderByDateDesc() {
        return examDataMapper.toDomain(
                examDataJpaRepository.findFirstByOrderByDateDesc()
        );
    }

    @Override
    public Boolean existsExamDataByDateAndPeriod(LocalDate date, Integer period) {
        return examDataJpaRepository.existsByDateAndPeriod(date, period);
    }
}
