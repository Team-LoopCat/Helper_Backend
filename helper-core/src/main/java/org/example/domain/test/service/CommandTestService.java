package org.example.domain.test.service;

import org.example.domain.test.model.Test;

public interface CommandTestService {

    Test saveTest(Test test);

    void deleteTest(Test test);
}
