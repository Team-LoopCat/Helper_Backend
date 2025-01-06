package org.example.domain.study.dto.response;

import java.util.UUID;
import org.example.domain.study.model.Category;
import org.example.domain.study.spi.vo.StudyWithMemberCountVO;

public record GetStudyDetailResponseDto(
        UUID studyId,
        String title,
        String content,
        Integer member,
        String location,
        String date,
        String start,
        String end,
        Category category
) {
    public static GetStudyDetailResponseDto from(StudyWithMemberCountVO study) {
        return new GetStudyDetailResponseDto(
                study.studyId(),
                study.title(),
                study.content(),
                study.member(),
                study.location(),
                study.date(),
                study.start(),
                study.end(),
                study.category()
        );
    }
}
