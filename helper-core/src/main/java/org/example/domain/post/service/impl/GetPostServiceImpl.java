package org.example.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.exception.PostNotFoundException;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.GetPostService;
import org.example.domain.post.spi.QueryPostPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetPostServiceImpl implements GetPostService {
    private final QueryPostPort queryPostPort;

    @Override
    public Post getPostByPostId(UUID postId) {
        return queryPostPort.getPostByPostId(postId).orElseThrow(
                () -> PostNotFoundException.EXCEPTION
        );
    }
}
