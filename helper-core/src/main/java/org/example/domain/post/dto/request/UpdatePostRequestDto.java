package org.example.domain.post.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.common.annotation.ValidEnum;
import org.example.domain.post.dto.vo.FileDataVO;
import org.example.domain.post.model.PostCategory;

import java.util.List;

public record UpdatePostRequestDto(
        @NotBlank String title,
        @NotBlank String contents,
        String photo,
        @NotNull @Size(max = 10) List<@NotBlank @Size(max = 15) String> tag,
        @ValidEnum(enumClass = PostCategory.class) PostCategory category,
        @NotNull @Size(max = 2) List<FileDataVO> fileData
) {
}
