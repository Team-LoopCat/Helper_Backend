package org.example.domain.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CreateReplyRequestDto(
        @Pattern(regexp = "^@.*", message = "mention은 @로 시작해야 합니다")
        @Length(max = 11) String mention,
        @NotBlank String contents
) {
}
