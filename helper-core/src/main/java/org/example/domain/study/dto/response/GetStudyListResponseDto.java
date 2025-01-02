package org.example.domain.study.dto.response;

import java.util.List;
import java.util.UUID;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;

public record GetStudyListResponseDto(
        List<GetStudyResponseDto> studies
) {
    public static GetStudyListResponseDto from(List<StudyWithMemberCountVO> studies) {
        return new GetStudyListResponseDto(
                studies.stream().map(GetStudyResponseDto::new).toList()
        );
    }
}

record GetStudyResponseDto(
        UUID studyId,
        String title,
        Integer member,
        String date,
        String start,
        String end
) {
     GetStudyResponseDto(StudyWithMemberCountVO study) {
         this(
                 study.studyId(),
                 study.title(),
                 study.member(),
                 study.date(),
                 study.start(),
                 study.end()
         );
    }
}