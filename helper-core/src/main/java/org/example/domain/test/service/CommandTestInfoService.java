package org.example.domain.test.service;

import org.example.domain.test.model.Test;
import org.example.domain.test.model.TestInfo;

public interface CommandTestInfoService {

    void saveTestInfo(TestInfo testInfo);

    void deleteAllByTest(Test test);
}
