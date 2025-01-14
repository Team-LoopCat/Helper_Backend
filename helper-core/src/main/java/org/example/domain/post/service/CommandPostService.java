package org.example.domain.post.service;

import org.example.domain.post.model.Post;

public interface CommandPostService {

    Post savePost(Post post);

    void deletePost(Post post);
}
