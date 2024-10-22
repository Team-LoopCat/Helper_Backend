package org.example.persistence.study.repository;

import java.util.UUID;
import org.example.persistence.study.entity.MemberJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberJpaRepository extends CrudRepository<MemberJpaEntity, UUID> {

}
