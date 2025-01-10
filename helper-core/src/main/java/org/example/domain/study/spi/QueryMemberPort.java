package org.example.domain.study.spi;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.domain.student.model.Student;
import org.example.domain.study.model.Member;

public interface QueryMemberPort {

    Member saveMember(Member member);

    Optional<Boolean> findIsBannedByStudyIdAndStudentId(UUID studyId, String studentId);

    Optional<Member> findByStudyIdAndStudentId(UUID studyId, String studentId);

    List<Student> findAllStudentByStudyId(UUID studyId);

    void deleteMember(Member member);
}
