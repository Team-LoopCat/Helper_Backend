package org.example.persistence.teacher.mapper;

import lombok.RequiredArgsConstructor;
import org.example.domain.teacher.model.Teacher;
import org.example.persistence.GenericMapper;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.example.persistence.auth.repository.UserJpaRepository;
import org.example.persistence.teacher.entity.TeacherJpaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TeacherMapper implements GenericMapper<Teacher, TeacherJpaEntity> {
    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<Teacher> toDomain(TeacherJpaEntity entity) {
        if (entity == null) return Optional.empty();

        return Optional.of(new Teacher(
                teacherEntity.getTeacherId(),
                teacherEntity.getUser().getUserId(),
                teacherEntity.getName()
        ));
    }

    @Override
    public TeacherJpaEntity toEntity(Teacher entity) {
        UserJpaEntity userJpaEntity = userJpaRepository.findByUserId(entity.getUserId()).orElseThrow();

        return new TeacherJpaEntity(
                entity.getTeacherId(),
                userJpaEntity,
                entity.getName()
        );
    }
}
