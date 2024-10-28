package org.example.persistence.test.repository;

import org.example.persistence.test.entity.TestInfoId;
import org.example.persistence.test.entity.TestInfoJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestInfoJpaRepository extends CrudRepository<TestInfoJpaEntity, TestInfoId> {

}
