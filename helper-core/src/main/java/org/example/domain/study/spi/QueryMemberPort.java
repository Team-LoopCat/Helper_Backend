package org.example.domain.study.spi;

import java.util.Optional;
import java.util.UUID;
import org.example.domain.study.model.Member;

public interface QueryMemberPort {

    Member saveMember(Member member);

    Optional<Boolean> findIsBannedByStudyIdAndStudentId(UUID studyId, String studentId);

    Optional<Member> findByStudyIdAndStudentId(UUID studyId, String studentId);
}
