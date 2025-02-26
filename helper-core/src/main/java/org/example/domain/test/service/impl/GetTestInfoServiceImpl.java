package org.example.domain.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.test.service.GetTestInfoService;
import org.example.domain.test.spi.QueryTestInfoPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTestInfoServiceImpl implements GetTestInfoService {
    private final QueryTestInfoPort queryTestInfoPort;
}
