package org.example.persistence.file.repository;

import java.util.UUID;
import org.example.persistence.file.entity.FileJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface FileJpaRepository extends CrudRepository<FileJpaEntity, UUID> {

}
