package org.example.domain.comment.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateCommentRequestDto(
        @NotBlank String contents
) {
}
