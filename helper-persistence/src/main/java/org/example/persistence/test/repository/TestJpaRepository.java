package org.example.persistence.test.repository;

import java.util.UUID;
import org.example.persistence.test.entity.TestJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestJpaRepository extends CrudRepository<TestJpaEntity, UUID> {

}
