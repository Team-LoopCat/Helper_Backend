package org.example.domain.post.service;

import org.example.domain.post.dto.vo.PostListVO;
import org.example.domain.post.model.Post;
import org.example.domain.post.model.PostCategory;

import java.util.List;
import java.util.UUID;

public interface GetPostService {

    Post getPostByPostId(UUID postId);

    List<PostListVO> searchAllPostLikeKeywordAndCategory(String keyword, PostCategory category);
}
