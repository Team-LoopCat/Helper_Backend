package org.example.persistence.study.repository;

import org.example.persistence.study.entity.MemberId;
import org.example.persistence.study.entity.MemberJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberJpaRepository extends CrudRepository<MemberJpaEntity, MemberId> {

}
