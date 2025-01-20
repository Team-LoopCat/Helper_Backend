package org.example.domain.post.dto.response;

import org.example.domain.post.dto.vo.PostListDataVO;

import java.util.List;

public record GetPostListResponseDto(
        List<PostListDataVO> posts
) {
}