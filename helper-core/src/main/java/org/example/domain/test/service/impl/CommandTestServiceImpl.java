package org.example.domain.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.test.model.Test;
import org.example.domain.test.service.CommandTestService;
import org.example.domain.test.spi.QueryTestPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandTestServiceImpl implements CommandTestService {
    private final QueryTestPort queryTestPort;

    @Override
    public Test saveTest(Test test) {
        return queryTestPort.saveTest(test);
    }

    @Override
    public void deleteTest(Test test) {
        queryTestPort.deleteTest(test);
    }
}
