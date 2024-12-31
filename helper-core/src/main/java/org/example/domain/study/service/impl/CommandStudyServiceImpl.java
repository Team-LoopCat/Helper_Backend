package org.example.domain.study.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.CommandStudyService;
import org.example.domain.study.spi.QueryStudyPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandStudyServiceImpl implements CommandStudyService {
    private final QueryStudyPort queryStudyPort;

    @Override
    public Study saveStudy(Study study) {
        return queryStudyPort.saveStudy(study);
    }

    @Override
    public void deleteStudy(Study study) {
        queryStudyPort.deleteStudyByStudyId(study.getStudyId());
    }
}
