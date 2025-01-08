package org.example.domain.study.spi;

import java.util.Optional;
import java.util.UUID;
import org.example.domain.study.model.Member;

public interface QueryMemberPort {

    Member saveMember(Member member);

    boolean existsByStudyIdAndStudentId(UUID studyId, String studentId);

    Optional<Member> findByStudyIdAndStudentId(UUID studyId, String studentId);

    void deleteMember(Member member);
}
