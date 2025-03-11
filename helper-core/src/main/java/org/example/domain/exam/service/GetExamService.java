package org.example.domain.exam.service;

import java.util.List;
import java.util.UUID;
import org.example.domain.exam.model.Exam;

public interface GetExamService {

    Exam getExamById(UUID examId);

    List<Exam> getExamList();
}
