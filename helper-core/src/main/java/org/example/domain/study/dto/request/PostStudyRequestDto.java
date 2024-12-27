package org.example.domain.study.dto.request;

import java.util.UUID;
import org.example.domain.study.model.Category;

public record PostStudyRequestDto(
        UUID subjectId,
        String title,
        String content,
        String location,
        String date,
        String start,
        String end,
        Category category
) { }
