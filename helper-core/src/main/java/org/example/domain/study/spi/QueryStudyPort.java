package org.example.domain.study.spi;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.domain.study.model.Study;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;

public interface QueryStudyPort {

    Optional<Study> findByStudyId(UUID studyId);

    Study saveStudy(Study study);

    void deleteStudyByStudyId(UUID studyId);

    List<StudyWithMemberCountVO> findAllBySubjectId(UUID subjectId);
}
