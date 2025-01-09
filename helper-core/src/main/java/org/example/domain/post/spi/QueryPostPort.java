package org.example.domain.post.spi;

import org.example.domain.post.model.Post;


public interface QueryPostPort {

    Post savePost(Post post);
}
