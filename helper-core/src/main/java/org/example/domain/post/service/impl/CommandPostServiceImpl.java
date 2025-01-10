package org.example.domain.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CommandPostService;
import org.example.domain.post.spi.QueryPostPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandPostServiceImpl implements CommandPostService {
    private final QueryPostPort queryPostPort;

    @Override
    public Post savePost(Post post) {
        return queryPostPort.savePost(post);
    }

    @Override
    public void deletePost(Post post) { queryPostPort.deletePost(post); }
}
