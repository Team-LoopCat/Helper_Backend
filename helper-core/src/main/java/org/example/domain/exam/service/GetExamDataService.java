package org.example.domain.exam.service;

import java.util.UUID;
import org.example.domain.exam.model.ExamData;

public interface GetExamDataService {

    ExamData getExamDataById(UUID examDataId);
}
