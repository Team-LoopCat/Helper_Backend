package org.example.domain.test.spi;

import org.example.domain.test.model.Test;

import java.util.Optional;
import java.util.UUID;

public interface QueryTestPort {

    Test saveTest(Test test);

    Optional<Test> getTestById(UUID testId);

    void deleteTest(Test test);
}
