package org.example.domain.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.test.model.TestInfo;
import org.example.domain.test.service.CommandTestInfoService;
import org.example.domain.test.spi.QueryTestInfoPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandTestInfoServiceImpl implements CommandTestInfoService {
    private final QueryTestInfoPort queryTestInfoPort;

    @Override
    public void saveTestInfo(TestInfo testInfo) {
        queryTestInfoPort.saveTestInfo(testInfo);
    }
}
