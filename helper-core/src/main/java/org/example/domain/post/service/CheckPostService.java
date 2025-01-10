package org.example.domain.post.service;

import org.example.domain.post.model.Post;

import java.util.UUID;

public interface CheckPostService {

    void checkIsWriter(Post post, String studentId);

    void checkPostExists(UUID postId);
}
