package org.example.persistence.exam;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.spi.QueryExamPort;
import org.example.persistence.exam.mapper.ExamMapper;
import org.example.persistence.exam.repository.ExamJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExamPersistenceAdapter implements QueryExamPort {
    private final ExamJpaRepository examJpaRepository;
    private final ExamMapper examMapper;

    @Override
    public boolean existsExamByGrade(String grade) {
        return examJpaRepository.existsByGrade(grade);
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
    public void deleteAllExams() {
        examJpaRepository.deleteAll();
    }
}
