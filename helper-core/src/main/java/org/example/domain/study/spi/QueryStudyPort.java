package org.example.domain.study.spi;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.domain.study.model.Category;
import org.example.domain.study.model.Study;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;

public interface QueryStudyPort {

    Optional<Study> findByStudyId(UUID studyId);

    Optional<StudyWithMemberCountVO> findStudyDetailByStudyId(UUID studyId);

    Study saveStudy(Study study);

    void deleteStudyByStudyId(UUID studyId);

    List<StudyWithMemberCountVO> findAllWithCount();

    List<StudyWithMemberCountVO> findAllByCategory(Category category);
}
