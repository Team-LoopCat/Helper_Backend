package org.example.domain.post.dto.vo;

import org.example.domain.post.model.Post;
import org.example.domain.post.spi.vo.PostListDatumVO;

import java.util.UUID;

public record PostListVO(
        UUID postId,
        String title,
        String contents,
        String[] tag,
        Long commentCount
) {
    public static PostListVO of(PostListDatumVO postListDatum) {
        return new PostListVO(
                postListDatum.postId(),
                postListDatum.title(),
                postListDatum.contents(),
                postListDatum.tag().split(","),
                postListDatum.commentCount()
        );
    }
}
