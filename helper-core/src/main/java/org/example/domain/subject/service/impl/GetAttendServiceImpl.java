package org.example.domain.subject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.model.Attend;
import org.example.domain.subject.service.GetAttendService;
import org.example.domain.subject.spi.QueryAttendPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetAttendServiceImpl implements GetAttendService {
    private final QueryAttendPort queryAttendPort;

    @Override
    public List<Attend> getAttendsByTestId(UUID testId) {
        return queryAttendPort.getAttendsByTest(testId);
    }
}
