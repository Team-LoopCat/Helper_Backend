package org.example.domain.test.spi;

import org.example.domain.test.model.Test;
import org.example.domain.test.model.TestInfo;

public interface QueryTestInfoPort {

    void saveTestInfo(TestInfo testInfo);

    void deleteAllByTest(Test test);
}
