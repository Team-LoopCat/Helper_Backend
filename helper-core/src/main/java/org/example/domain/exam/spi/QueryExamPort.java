package org.example.domain.exam.spi;

import java.util.List;
import java.util.Optional;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.model.ExamData;

public interface QueryExamPort {

    boolean existsExamByGrade(String grade);

    List<Exam> saveAll(List<Exam> exams);

    List<Exam> queryAllExams();

    Optional<Exam> queryFirstExamOrderByDateDesc();

    void deleteAllExams();

    Exam saveExam(Exam exam);
}
