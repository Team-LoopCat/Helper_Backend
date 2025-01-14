package org.example.domain.study.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.example.common.annotation.ValidEnum;
import org.example.domain.study.model.Category;

public record UpdateStudyRequestDto(
        @NotBlank String title,
        @NotBlank String content,
        @NotBlank String location,
        @NotBlank String date,
        @NotBlank String start,
        @NotBlank String end,
        @ValidEnum(enumClass = Category.class) Category category
) { }
