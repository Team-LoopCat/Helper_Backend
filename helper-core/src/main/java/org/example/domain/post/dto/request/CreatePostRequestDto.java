package org.example.domain.post.dto.request;

import org.example.domain.post.dto.vo.FileDataVO;
import org.example.domain.post.model.PostCategory;

import java.util.List;

public record CreatePostRequestDto(
        String title,
        String contents,
        String photo,
        List<String> tag,
        PostCategory category,
        List<FileDataVO> fileData
) {
}
