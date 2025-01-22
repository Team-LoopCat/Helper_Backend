package org.example.domain.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record CreateReplyRequestDto(
        @Length(max = 11) String mention,
        @NotBlank String contents
) {
}
