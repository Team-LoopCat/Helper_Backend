package org.example.persistence.study.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.study.model.Study;
import org.example.persistence.GenericMapper;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.example.persistence.student.repository.StudentJpaRepository;
import org.example.persistence.study.entity.StudyJpaEntity;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.example.persistence.subject.repository.SubjectJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudyMapper implements GenericMapper<Study, StudyJpaEntity> {
    private final StudentJpaRepository studentJpaRepository;
    private final SubjectJpaRepository subjectJpaRepository;

    @Override
    public Optional<Study> toDomain(Optional<StudyJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        StudyJpaEntity studyJpaEntity = entity.get();

        return Optional.of(new Study(
                studyJpaEntity.getStudyId(),
                studyJpaEntity.getStudent().getStudentId(),
                studyJpaEntity.getSubject().getSubjectId(),
                studyJpaEntity.getTitle(),
                studyJpaEntity.getContent(),
                studyJpaEntity.getLocation(),
                studyJpaEntity.getDate(),
                studyJpaEntity.getEnd(),
                studyJpaEntity.getCategory()
        ));
    }

    @Override
    public StudyJpaEntity toEntity(Study entity) {
        StudentJpaEntity studentJpaEntity = studentJpaRepository.findByStudentId
                (entity.getStudentId()).orElse(null);

        SubjectJpaEntity subjectJpaEntity = subjectJpaRepository.findById
                (entity.getSubjectId()).orElse(null);

        return new StudyJpaEntity(
                entity.getStudyId(),
                studentJpaEntity,
                subjectJpaEntity,
                entity.getTitle(),
                entity.getContent(),
                entity.getLocation(),
                entity.getDate(),
                entity.getEnd(),
                entity.getCategory()
        );
    }
}
