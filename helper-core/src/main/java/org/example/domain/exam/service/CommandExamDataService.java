package org.example.domain.exam.service;

import java.util.List;
import org.example.domain.exam.dto.request.ExamDataRequestDto;
import org.example.domain.exam.model.Exam;
import org.example.domain.exam.model.ExamData;

public interface CommandExamDataService {

    List<ExamData> saveAllExamData(Exam exam, List<ExamDataRequestDto> examData);

    ExamData saveExamData(ExamData examData);
}
