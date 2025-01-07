package org.example.persistence.study.repository;

import java.util.Optional;
import java.util.UUID;
import org.example.persistence.study.entity.MemberId;
import org.example.persistence.study.entity.MemberJpaEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberJpaRepository extends CrudRepository<MemberJpaEntity, MemberId> {

    boolean existsByStudyIdAndStudentId(UUID studyId, String studentId);

    Optional<MemberJpaEntity> findByStudyIdAndStudentId(UUID studyId, String studentId);
}
