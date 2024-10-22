package org.example.persistence.test.repository;

import java.util.UUID;
import org.example.persistence.test.entity.TestInfoId;
import org.example.persistence.test.entity.TestInfoJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestInfoJpaRepository extends CrudRepository<TestInfoJpaEntity, TestInfoId> {

}
