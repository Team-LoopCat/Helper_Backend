package org.example.domain.post.service;

import org.example.domain.post.model.Post;

public interface CheckPostService {
    void checkIsWriter(Post post, String studentId);
}
