package org.example.domain.study.service;

import java.util.UUID;
import org.example.domain.study.model.Study;

public interface GetStudyService {

    Study getStudyById(UUID studyId);
}
