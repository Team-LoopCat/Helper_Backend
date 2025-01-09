package org.example.persistence.file;

import lombok.RequiredArgsConstructor;
import org.example.domain.file.model.File;
import org.example.domain.file.spi.QueryFilePort;
import org.example.persistence.file.mapper.FileMapper;
import org.example.persistence.file.repository.FileJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilePersistenceAdapter implements QueryFilePort {
    private final FileJpaRepository fileJpaRepository;
    private final FileMapper fileMapper;

    @Override
    public void saveFile(File file) {
        fileJpaRepository.save(fileMapper.toEntity(file));
    }
}
