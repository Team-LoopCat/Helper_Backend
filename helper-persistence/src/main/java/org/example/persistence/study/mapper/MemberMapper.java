package org.example.persistence.study.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.model.Member;
import org.example.persistence.GenericMapper;
import org.example.persistence.study.entity.MemberJpaEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberMapper implements GenericMapper<Member, MemberJpaEntity> {

    @Override
    public Optional<Member> toDomain(Optional<MemberJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        MemberJpaEntity memberEntity = entity.get();

        return Optional.of(new Member(
                memberEntity.getStudentId(),
                memberEntity.getStudyId(),
                memberEntity.getIsBanned()
        ));
    }

    @Override
    public MemberJpaEntity toEntity(Member entity) {
        return new MemberJpaEntity(
                entity.getStudentId(),
                entity.getStudyId(),
                entity.getIsBanned()
        );
    }
}
