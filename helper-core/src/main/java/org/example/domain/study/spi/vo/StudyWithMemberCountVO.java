package org.example.domain.study.spi.vo;

import java.util.UUID;
import org.example.domain.study.model.Category;

public record StudyWithMemberCountVO(
        UUID studyId,
        String studentId,
        String title,
        String content,
        String location,
        String date,
        String start,
        String end,
        Category category,
        Integer member
) { }
