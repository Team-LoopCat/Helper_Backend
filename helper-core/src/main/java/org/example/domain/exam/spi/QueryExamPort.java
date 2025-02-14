package org.example.domain.exam.spi;

import java.util.List;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.model.ExamData;

public interface QueryExamPort {

    boolean existsExamByGrade(String grade);

    Exam saveExam(Exam exam);
}
