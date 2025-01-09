package org.example.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CommendPostService;
import org.example.domain.post.spi.QueryPostPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommendPostServiceImpl implements CommendPostService {
    private final QueryPostPort queryPostPort;

    @Override
    public Post savePost(Post post) {
        return queryPostPort.savePost(post);
    }
}
