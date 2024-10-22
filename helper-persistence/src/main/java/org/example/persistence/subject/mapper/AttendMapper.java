package org.example.persistence.subject.mapper;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.subject.model.Attend;
import org.example.persistence.GenericMapper;
import org.example.persistence.student.entity.GradeInfoJpaEntity;
import org.example.persistence.student.repository.GradeInfoJpaRepository;
import org.example.persistence.subject.entity.AttendJpaEntity;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.example.persistence.subject.repository.SubjectJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttendMapper implements GenericMapper<Attend, AttendJpaEntity> {
    private final GradeInfoJpaRepository gradeInfoJpaRepository;
    private final SubjectJpaRepository subjectJpaRepository;

    @Override
    public Optional<Attend> toDomain(Optional<AttendJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        AttendJpaEntity attendEntity = entity.get();

        return Optional.of(new Attend(
                attendEntity.getAttendId(),
                attendEntity.getGradeInfo().getGrade(),
                attendEntity.getGradeInfo().getClassroom(),
                attendEntity.getSubject().getSubjectId()
        ));
    }

    @Override
    public AttendJpaEntity toEntity(Attend entity) {
        GradeInfoJpaEntity gradeInfoJpaEntity = gradeInfoJpaRepository.findByClassroomAndGrade
                (entity.getClassroom(), entity.getGrade()).orElse(null);

        SubjectJpaEntity subjectJpaEntity = subjectJpaRepository.findById
                (entity.getSubjectId()).orElse(null);

        return new AttendJpaEntity(
                entity.getAttendId(),
                gradeInfoJpaEntity,
                subjectJpaEntity
        );
    }
}
