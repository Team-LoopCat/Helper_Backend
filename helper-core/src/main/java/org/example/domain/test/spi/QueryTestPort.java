package org.example.domain.test.spi;

import org.example.domain.test.model.Test;

public interface QueryTestPort {

    Test saveTest(Test test);
}
