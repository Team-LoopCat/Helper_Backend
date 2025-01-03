package org.example.domain.study.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.dto.response.GetStudyDetailResponseDto;
import org.example.domain.study.service.GetStudyService;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetStudyDetailUseCase {
    private final GetStudyService getStudyService;

    public GetStudyDetailResponseDto execute(UUID studyId) {
        StudyWithMemberCountVO currentStudy = getStudyService.getStudyDetailById(studyId);

        return GetStudyDetailResponseDto.from(currentStudy);
    }
}
