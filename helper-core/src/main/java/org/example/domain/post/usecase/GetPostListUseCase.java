package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.dto.response.GetPostListResponseDto;
import org.example.domain.post.dto.vo.PostListDataVO;
import org.example.domain.post.service.GetPostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetPostListUseCase {
    private final GetPostService getPostService;

    public GetPostListResponseDto execute(String keyword) {
        List<PostListDataVO> searchedPosts = getPostService.searchAllPostLikeKeyword(keyword);

        return new GetPostListResponseDto(searchedPosts);
    }
}
