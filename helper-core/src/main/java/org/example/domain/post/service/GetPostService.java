package org.example.domain.post.service;

import org.example.domain.post.dto.vo.PostListDataVO;
import org.example.domain.post.model.Post;

import java.util.List;
import java.util.UUID;

public interface GetPostService {

    Post getPostByPostId(UUID postId);

    List<PostListDataVO> searchAllPostLikeKeyword(String keyword);
}
