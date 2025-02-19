package org.example.domain.exam.spi;

import java.util.List;
import org.example.domain.exam.model.Exam;

public interface QueryExamPort {

    boolean existsExamByGrade(String grade);

    List<Exam> queryAllExams();

    void deleteAllExams();

    Exam saveExam(Exam exam);
}
