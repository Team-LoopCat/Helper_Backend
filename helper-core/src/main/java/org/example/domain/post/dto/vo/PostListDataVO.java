package org.example.domain.post.dto.vo;

import org.example.domain.post.model.Post;

import java.util.UUID;

public record PostListDataVO(
        UUID postId,
        String title,
        String contents,
        String[] tag,
        int commentCount
) {
    public static PostListDataVO of(Post post, int commentCount) {
        return new PostListDataVO(
                post.getPostId(),
                post.getTitle(),
                post.getContent(),
                post.getTag().split(","),
                commentCount
        );
    }
}
