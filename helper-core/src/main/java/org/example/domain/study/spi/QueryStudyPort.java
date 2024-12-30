package org.example.domain.study.spi;

import org.example.domain.study.model.Study;

public interface QueryStudyPort {

    Study saveStudy(Study study);
}
