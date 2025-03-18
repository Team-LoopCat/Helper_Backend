package org.example.domain.subject.service;

import org.example.domain.subject.model.Attend;

import java.util.List;
import java.util.UUID;

public interface GetAttendService {

    List<Attend> getAttendsByTestId(UUID testId);
}
