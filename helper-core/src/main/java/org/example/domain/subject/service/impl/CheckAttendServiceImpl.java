package org.example.domain.subject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.exception.AttendDataNotFoundException;
import org.example.domain.subject.service.CheckAttendService;
import org.example.domain.subject.spi.QueryAttendPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckAttendServiceImpl implements CheckAttendService {
    private final QueryAttendPort queryAttendPort;

    @Override
    public void checkAttendExistByAttendId(UUID attendId) {
        if (!queryAttendPort.checkAttendExistsByAttendId(attendId)) {
            throw AttendDataNotFoundException.EXCEPTION;
        }
    }
}
