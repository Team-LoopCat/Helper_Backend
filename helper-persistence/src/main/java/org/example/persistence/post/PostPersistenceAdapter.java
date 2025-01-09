package org.example.persistence.post;

import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.domain.post.spi.QueryPostPort;
import org.example.persistence.post.mapper.PostMapper;
import org.example.persistence.post.repository.PostJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PostPersistenceAdapter implements QueryPostPort {
    private final PostJpaRepository postJpaRepository;
    private final PostMapper postMapper;

    @Override
    public Post savePost(Post post) {
        return postMapper.toDomain(
                Optional.of(postJpaRepository.save(postMapper.toEntity(post)))
        ).get();
    }

    @Override
    public Optional<Post> getPostByPostId(UUID postId) {
        return postMapper.toDomain(postJpaRepository.getPostJpaEntityByPostId(postId));
    }

    @Override
    public void deletePost(Post post) {
        postJpaRepository.delete(postMapper.toEntity(post));
    }
}
