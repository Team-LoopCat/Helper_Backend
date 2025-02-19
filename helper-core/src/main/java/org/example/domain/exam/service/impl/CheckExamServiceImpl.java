package org.example.domain.exam.service.impl;

import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.exception.AlreadyStartedException;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.service.CheckExamService;
import org.example.domain.exam.spi.QueryExamPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckExamServiceImpl implements CheckExamService {
    private final QueryExamPort queryExamPort;

    @Override
    public void checkExamHasStarted() {
        if (queryExamPort.existsAnyExam()) {
            throw AlreadyStartedException.EXCEPTION;
        }
    }

    @Override
    public Boolean checkExamWasFinished() {
        Optional<Exam> optionalExam = queryExamPort.queryFirstExamOrderByDateDesc();

        return optionalExam.map(exam ->
                exam.getEnd().isBefore(LocalDate.now())
        ).orElse(false);
    }
}
