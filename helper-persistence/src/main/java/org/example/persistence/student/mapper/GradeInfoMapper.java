package org.example.persistence.student.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.GradeInfo;
import org.example.persistence.GenericMapper;
import org.example.persistence.student.entity.GradeInfoJpaEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GradeInfoMapper implements GenericMapper<GradeInfo, GradeInfoJpaEntity> {
    @Override
    public Optional<GradeInfo> toDomain(Optional<GradeInfoJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        GradeInfoJpaEntity gradeInfoEntity = entity.get();

        return Optional.of(new GradeInfo(
                gradeInfoEntity.getGrade(),
                gradeInfoEntity.getClassroom(),
                gradeInfoEntity.getMajor()
        ));
    }

    @Override
    public GradeInfoJpaEntity toEntity(GradeInfo entity) {
        return new GradeInfoJpaEntity(
                entity.getGrade(),
                entity.getClassroom(),
                entity.getMajor()
        );
    }
}
