package org.example.domain.study.service.impl;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.exception.StudyNotFoundException;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.GetStudyService;
import org.example.domain.study.spi.QueryStudyPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStudyServiceImpl implements GetStudyService {
    private final QueryStudyPort queryStudyPort;

    @Override
    public Study getStudyById(UUID studyId) {
        return queryStudyPort.findByStudyId(studyId).orElseThrow(
                () -> StudyNotFoundException.EXCEPTION
        );
    }
}
