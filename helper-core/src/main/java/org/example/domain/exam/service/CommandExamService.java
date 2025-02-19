package org.example.domain.exam.service;

import org.example.domain.exam.model.Exam;
import org.example.domain.student.model.Major;

public interface CommandExamService {

    void deleteAllExams();
  
    Exam startExam(Major major, String grade);
}
