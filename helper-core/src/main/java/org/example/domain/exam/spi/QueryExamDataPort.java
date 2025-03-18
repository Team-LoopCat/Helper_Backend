package org.example.domain.exam.spi;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.domain.exam.model.ExamData;

public interface QueryExamDataPort {

    List<ExamData> saveAllExamData(List<ExamData> examData);

    ExamData saveExamData(ExamData examData);

    Optional<ExamData> queryFirstExamDataOrderByDateDesc();

    Optional<ExamData> queryExamDataById(UUID examDataId);

    Boolean existsExamDataByDateAndPeriod(LocalDate date, Integer period);
}
