package org.example.domain.exam.service;

import java.time.LocalDate;

public interface CheckExamDataService {

    void checkDateAndPeriodHaveBeenDuplicated(LocalDate date, Integer period);
}
