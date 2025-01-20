package org.example.domain.post.spi;

import org.example.domain.post.dto.vo.PostListDataVO;
import org.example.domain.post.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QueryPostPort {

    Post savePost(Post post);

    Optional<Post> getPostByPostId(UUID postId);

    void deletePost(Post post);

    Boolean checkPostExists(UUID postId);

    List<PostListDataVO> searchAllPostLikeKeyword(String keyword);
}
