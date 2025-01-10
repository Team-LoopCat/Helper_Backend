package org.example.persistence.study.repository;

import java.util.Optional;
import java.util.UUID;
import org.example.persistence.study.entity.MemberId;
import org.example.persistence.study.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MemberJpaRepository extends CrudRepository<MemberJpaEntity, MemberId> {

    @Query(value =
            "SELECT m.isBanned " +
            "FROM member m " +
            "WHERE m.studyId = :studyId AND " +
                    "m.studentId = :studentId"
    )
    Optional<Boolean> findIsBannedByStudyIdAndStudentId(@Param("studyId") UUID studyId, @Param("studentId") String studentId);

    Optional<MemberJpaEntity> findByStudyIdAndStudentId(UUID studyId, String studentId);
}
