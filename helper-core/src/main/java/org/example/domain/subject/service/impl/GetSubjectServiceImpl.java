package org.example.domain.subject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.exception.SubjectNotFoundException;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.service.GetSubjectService;
import org.example.domain.subject.spi.QuerySubjectPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetSubjectServiceImpl implements GetSubjectService {
    private final QuerySubjectPort querySubjectPort;

    @Override
    public Subject getSubjectById(UUID id) {
        return querySubjectPort.getSubjectById(id).orElseThrow(
                () -> SubjectNotFoundException.EXCEPTION
        );
    }
}
