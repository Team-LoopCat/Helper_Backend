package org.example.persistence.exam;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.model.Exam;
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
    public List<Exam> saveAll(List<Exam> exams) {
        return StreamSupport.stream(
                examJpaRepository.saveAll(
                        exams.stream().map(examMapper::toEntity).toList()
                ).spliterator(), false)
                .map(entity ->
                        examMapper.toDomain(
                                Optional.of(entity)
                        ).get()
                ).toList();
    }

    @Override
    public List<Exam> queryAllExams() {
        return StreamSupport.stream(
                examJpaRepository.findAll()
                .spliterator(), false)
                .map(entity ->
                        examMapper.toDomain(
                                Optional.of(entity)
                        ).get()
                ).toList();
    }

    @Override
    public Optional<Exam> queryFirstExamOrderByDateDesc() {
        return examMapper.toDomain(
                examDataJpaRepository.findFirstByOrderByDateDesc()
        );
    }

    @Override
    public void deleteAllExams() {
        examJpaRepository.deleteAll();
    }
}
