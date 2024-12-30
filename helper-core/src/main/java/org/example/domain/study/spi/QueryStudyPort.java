package org.example.domain.study.spi;

import java.util.Optional;
import java.util.UUID;
import org.example.domain.study.model.Study;

public interface QueryStudyPort {

    Optional<Study> findByStudyId(UUID studyId);

    Study saveStudy(Study study);

    void deleteStudyByStudyId(UUID studyId);
}
