package org.example.domain.exam.service.impl;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.exception.DuplicateDateOrPeriodException;
import org.example.domain.exam.service.CheckExamDataService;
import org.example.domain.exam.spi.QueryExamDataPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckExamDataServiceImpl implements CheckExamDataService {
    private final QueryExamDataPort queryExamDataPort;

    @Override
    public void checkDateOrPeriodHasBeenDuplicated(LocalDate date, Integer period) {
        if (queryExamDataPort.existsExamDataByDateAndPeriod(date, period)) {
            throw DuplicateDateOrPeriodException.EXCEPTION;
        }
    }
}
