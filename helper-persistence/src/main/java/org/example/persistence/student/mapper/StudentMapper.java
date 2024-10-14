package org.example.persistence.student.mapper;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.persistence.GenericMapper;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.example.persistence.auth.repository.UserJpaRepository;
import org.example.persistence.student.entity.GradeInfoJpaEntity;
import org.example.persistence.student.repository.GradeInfoJpaRepository;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentMapper implements GenericMapper<Student, StudentJpaEntity> {
    private final UserJpaRepository userRepository;
    private final GradeInfoJpaRepository gradeInfoJpaRepository;

    @Override
    public Optional<Student> toDomain(Optional<StudentJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        StudentJpaEntity studentEntity = entity.get();

        return Optional.of(new Student(
                studentEntity.getStudentId(),
                studentEntity.getGradeInfo().getGrade(),
                studentEntity.getGradeInfo().getClassroom(),
                null, // todo: subject 외래키 처리
                studentEntity.getUser().getUserId(),
                studentEntity.getNickname(),
                studentEntity.getEmail(),
                studentEntity.getUser().getRole()
        ));
    }

    @Override
    public StudentJpaEntity toEntity(Student entity) {
        UserJpaEntity userEntity = userRepository.findByUserId(entity.getUserId()).orElseThrow();
        GradeInfoJpaEntity gradeInfoJpaEntity = gradeInfoJpaRepository.findByClassroomAndGrade(entity.getClassroom(), entity.getGrade()).orElseThrow();
        // todo: subject 관련 로직 추가

        return new StudentJpaEntity(
                entity.getStudentId(),
                gradeInfoJpaEntity,
                userEntity,
                entity.getNickname(),
                entity.getEmail()
        );
    }
}
