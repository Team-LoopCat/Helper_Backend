package org.example.domain.post.spi.vo;

import java.util.UUID;

public record PostListDatumVO(
        UUID postId,
        String title,
        String contents,
        String tag,
        Long commentCount
) {
}
