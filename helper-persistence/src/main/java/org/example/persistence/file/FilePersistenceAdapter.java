package org.example.persistence.file;

import lombok.RequiredArgsConstructor;
import org.example.domain.file.model.File;
import org.example.domain.file.spi.QueryFilePort;
import org.example.domain.post.model.Post;
import org.example.persistence.file.mapper.FileMapper;
import org.example.persistence.file.repository.FileJpaRepository;
import org.example.persistence.post.mapper.PostMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilePersistenceAdapter implements QueryFilePort {
    private final FileJpaRepository fileJpaRepository;
    private final FileMapper fileMapper;
    private final PostMapper postMapper;

    @Override
    public void saveFile(File file) {
        fileJpaRepository.save(fileMapper.toEntity(file));
    }

    @Override
    public void deleteAllByPost(Post post) {
        fileJpaRepository.deleteAllByPost(
                postMapper.toEntity(post)
        );
    }
}
