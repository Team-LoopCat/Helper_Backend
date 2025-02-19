package org.example.domain.exam.service;

import java.time.LocalDate;

public interface CheckExamDataService {

    void checkDateOrPeriodHasBeenDuplicated(LocalDate date, Integer period);
}
