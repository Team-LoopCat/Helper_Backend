package org.example.domain.test.service;

import org.example.domain.test.model.Test;
import org.example.domain.test.spi.vo.TestListDataVO;

import java.util.List;
import java.util.UUID;

public interface GetTestService {

    Test getTestById(UUID testId);

    List<TestListDataVO> getTestListDataBySubjectId(UUID subjectId);
}
