package org.example.persistence.file.mapper;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.file.model.File;
import org.example.persistence.GenericMapper;
import org.example.persistence.file.entity.FileJpaEntity;
import org.example.persistence.post.entity.PostJpaEntity;
import org.example.persistence.post.repository.PostJpaRepository;
import org.example.persistence.test.entity.TestJpaEntity;
import org.example.persistence.test.repository.TestJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileMapper implements GenericMapper<File, FileJpaEntity> {
    private final PostJpaRepository postJpaRepository;
    private final TestJpaRepository testJpaRepository;

    @Override
    public Optional<File> toDomain(Optional<FileJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        FileJpaEntity fileEntity = entity.get();

        return Optional.of(new File(
                fileEntity.getFileId(),
                Optional.ofNullable(fileEntity.getPost().getPostId()),
                Optional.ofNullable(fileEntity.getTest().getTestId()),
                fileEntity.getUrl(),
                fileEntity.getFilename()
        ));
    }

    @Override
    public FileJpaEntity toEntity(File entity) {
        PostJpaEntity postJpaEntity = postJpaRepository.findById
                (entity.getPostId().orElse(new UUID(0, 0))).orElse(null);

        TestJpaEntity testJpaEntity = testJpaRepository.findById
                (entity.getTestId().orElse(new UUID(0, 0))).orElse(null);

        return new FileJpaEntity(
                entity.getFileId(),
                postJpaEntity,
                testJpaEntity,
                entity.getUrl(),
                entity.getFilename()
        );
    }
}
