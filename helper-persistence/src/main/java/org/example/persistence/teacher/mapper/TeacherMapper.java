package org.example.persistence.teacher.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.teacher.model.Teacher;
import org.example.persistence.GenericMapper;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.example.persistence.auth.repository.UserJpaRepository;
import org.example.persistence.teacher.entity.TeacherJpaEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherMapper implements GenericMapper<Teacher, TeacherJpaEntity> {
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<Teacher> toDomain(Optional<TeacherJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        TeacherJpaEntity teacherEntity = entity.get();

        return Optional.of(new Teacher(
                teacherEntity.getTeacherId(),
                teacherEntity.getUser().getUserId(),
                teacherEntity.getName(),
                Optional.ofNullable(teacherEntity.getGrade())
        ));
    }

    @Override
    public TeacherJpaEntity toEntity(Teacher entity) {
        UserJpaEntity userJpaEntity = userJpaRepository.findByUserId
                (entity.getUserId()).orElse(null);

        return new TeacherJpaEntity(
                entity.getTeacherId(),
                userJpaEntity,
                entity.getName(),
                entity.getGrade().orElse(null)
        );
    }
}
