package org.example.domain.study.usecase;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.dto.response.GetStudyListResponseDto;
import org.example.domain.study.model.Category;
import org.example.domain.study.service.GetStudyService;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetStudyListUseCase {
    private final GetStudyService getStudyService;

    public GetStudyListResponseDto execute(Category category) {
        List<StudyWithMemberCountVO> studies = (category == null) ?
            getStudyService.getAllStudyList() :
            getStudyService.getStudyListByCategory(category);

        return GetStudyListResponseDto.from(studies);
    }
}
