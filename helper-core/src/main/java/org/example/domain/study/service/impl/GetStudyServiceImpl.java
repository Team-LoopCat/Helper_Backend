package org.example.domain.study.service.impl;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.exception.StudyNotFoundException;
import org.example.domain.study.model.Category;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.GetStudyService;
import org.example.domain.study.spi.QueryStudyPort;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;
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

    @Override
    public List<StudyWithMemberCountVO> getStudyListByCategory(Category category) {
        return queryStudyPort.findAllByCategory(category);
    }
}
