package org.example.persistence.test.repository;

import org.example.domain.test.model.Test;
import org.example.persistence.test.entity.TestInfoId;
import org.example.persistence.test.entity.TestInfoJpaEntity;
import org.example.persistence.test.entity.TestJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestInfoJpaRepository extends CrudRepository<TestInfoJpaEntity, TestInfoId> {

    void deleteAllByTest(TestJpaEntity test);
}
