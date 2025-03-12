package org.example.domain.exam.service;

import java.util.List;
import java.util.UUID;
import org.example.domain.exam.model.ExamData;
import org.example.domain.exam.spi.vo.SimpleExamDataVO;

public interface GetExamDataService {

    ExamData getExamDataById(UUID examDataId);

    List<SimpleExamDataVO> getAllExamDataByExamDataId(UUID examDataId);
}
