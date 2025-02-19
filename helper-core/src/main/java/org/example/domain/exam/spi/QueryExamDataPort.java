package org.example.domain.exam.spi;

import java.util.List;
import org.example.domain.exam.model.ExamData;

public interface QueryExamDataPort {

    List<ExamData> saveAllExamData(List<ExamData> examData);
}
