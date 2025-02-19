package org.example.domain.exam.service;

public interface CheckExamService {

    void checkExamHasStartedByGrade(String grade);

    Boolean checkExamWasFinished();
}
