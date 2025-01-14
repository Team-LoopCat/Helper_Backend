package org.example.domain.comment.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateCommentRequestDto (
    @NotBlank String contents
) {
}
