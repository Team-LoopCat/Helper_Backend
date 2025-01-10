package org.example.persistence.study;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.model.Member;
import org.example.domain.study.spi.QueryMemberPort;
import org.example.persistence.study.mapper.MemberMapper;
import org.example.persistence.study.repository.MemberJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements QueryMemberPort {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberMapper memberMapper;

    @Override
    public Member saveMember(Member member) {
        return memberMapper.toDomain(
                Optional.of(memberJpaRepository.save(
                        memberMapper.toEntity(member)
                ))
        ).get();
    }

    @Override
    public Optional<Boolean> findIsBannedByStudyIdAndStudentId(UUID studyId, String studentId) {
        return memberJpaRepository.findIsBannedByStudyIdAndStudentId(studyId, studentId);
    }

    @Override
    public Optional<Member> findByStudyIdAndStudentId(UUID studyId, String studentId) {
        return memberMapper.toDomain(
                memberJpaRepository.findByStudyIdAndStudentId(studyId, studentId)
        );
    }
}
