package org.example.domain.exam.service.impl;

import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.exam.exception.AlreadyStartedException;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.service.CheckExamService;
import org.example.domain.exam.spi.QueryExamDataPort;
import org.example.domain.exam.spi.QueryExamPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckExamServiceImpl implements CheckExamService {
    private final QueryExamPort queryExamPort;
    private final QueryExamDataPort queryExamDataPort;

    @Override
    public void checkExamHasStartedByGrade(String grade) {
        if (queryExamPort.existsExamByGrade(grade)) {
            throw AlreadyStartedException.EXCEPTION;
        }
    }

    @Override
    public Boolean checkExamWasFinished() {
        Optional<ExamData> optionalExamData = queryExamDataPort.queryFirstExamDataOrderByDateDesc();

        return optionalExamData.map(exam ->
                optionalExamData.get().getDate().isBefore(LocalDate.now())
        ).orElse(false);
    }
}
