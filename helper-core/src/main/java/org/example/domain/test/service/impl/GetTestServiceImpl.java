package org.example.domain.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.test.exception.TestNotFoundException;
import org.example.domain.test.model.Test;
import org.example.domain.test.service.GetTestService;
import org.example.domain.test.spi.QueryTestPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTestServiceImpl implements GetTestService {
    private final QueryTestPort queryTestPort;

    @Override
    public Test getTestById(UUID testId) {
        return queryTestPort.getTestById(testId).orElseThrow(
                () -> TestNotFoundException.EXCEPTION
        );
    }
}
