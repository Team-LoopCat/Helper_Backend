package org.example.domain.exam.spi;

import java.util.List;
import java.util.Optional;
import org.example.domain.exam.model.Exam;

public interface QueryExamPort {

    boolean existsAnyExam();

    List<Exam> saveAll(List<Exam> exams);

    List<Exam> queryAllExams();

    Optional<Exam> queryFirstExamOrderByDateDesc();

    void deleteAllExams();
}
