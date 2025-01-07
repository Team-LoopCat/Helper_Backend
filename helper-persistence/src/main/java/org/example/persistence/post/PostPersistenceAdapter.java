package org.example.persistence.post;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.domain.post.spi.QueryPostPort;
import org.example.persistence.post.mapper.PostMapper;
import org.example.persistence.post.repository.PostJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostPersistenceAdapter implements QueryPostPort {
    private final PostJpaRepository postJpaRepository;
    private final PostMapper postMapper;

    @Override
    public void savePost(Post post) {
        postJpaRepository.save(postMapper.toEntity(post));
    }
}
