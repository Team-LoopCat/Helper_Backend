package org.example.domain.post.dto.response;

import org.example.domain.post.dto.vo.PostListVO;

import java.util.List;

public record GetPostListResponseDto(
        List<PostListVO> posts
) {
}