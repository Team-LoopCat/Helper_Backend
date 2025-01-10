package org.example.persistence.study;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.domain.study.model.Member;
import org.example.domain.study.spi.QueryMemberPort;
import org.example.persistence.student.mapper.StudentMapper;
import org.example.persistence.study.mapper.MemberMapper;
import org.example.persistence.study.repository.MemberJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements QueryMemberPort {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberMapper memberMapper;
    private final StudentMapper studentMapper;

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

    @Override
    public List<Student> findAllStudentByStudyId(UUID studyId) {
        return memberJpaRepository.findStudentByStudyId(studyId)
                .stream().map(entity ->
                        studentMapper.toDomain(
                                Optional.of(entity)
                        ).get()
                ).toList();
    }

    @Override
    public void deleteMember(Member member) {
        memberJpaRepository.delete(
                memberMapper.toEntity(member)
        );
    }
}
