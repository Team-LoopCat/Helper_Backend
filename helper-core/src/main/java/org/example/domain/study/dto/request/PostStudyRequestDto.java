package org.example.domain.study.dto.request;

import org.example.domain.study.model.Category;

public record PostStudyRequestDto(
        String title,
        String content,
        String location,
        String date,
        String start,
        String end,
        Category category
) { }
