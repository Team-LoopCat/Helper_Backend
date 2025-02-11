package org.example.domain.exam.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.exam.exception.AlreadyStartedException;
import org.example.domain.exam.service.CheckExamService;
import org.example.domain.exam.spi.QueryExamPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckExamServiceImpl implements CheckExamService {
    private final QueryExamPort queryExamPort;

    @Override
    public void checkExamHasStartedByGrade(String grade) {
        if (queryExamPort.existsExamByGrade(grade)) {
            throw AlreadyStartedException.EXCEPTION;
        }
    }
}
