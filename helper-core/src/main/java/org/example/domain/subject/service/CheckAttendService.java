package org.example.domain.subject.service;

import java.util.UUID;

public interface CheckAttendService {

    void checkAttendExistByAttendId(UUID attendId);
}
