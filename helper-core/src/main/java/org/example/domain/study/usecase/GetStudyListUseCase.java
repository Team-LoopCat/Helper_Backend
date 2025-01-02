package org.example.domain.study.usecase;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.dto.response.GetStudyListResponseDto;
import org.example.domain.study.model.Study;
import org.example.domain.study.service.GetStudyService;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.service.GetSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetStudyListUseCase {
    private final GetStudyService getStudyService;
    private final GetSubjectService getSubjectService;

    public GetStudyListResponseDto execute(UUID subjectId) {
        Subject subject = getSubjectService.getSubjectById(subjectId);

        List<StudyWithMemberCountVO> studies = getStudyService.getStudyListBySubject(subject);

        return GetStudyListResponseDto.from(studies);
    }
}
