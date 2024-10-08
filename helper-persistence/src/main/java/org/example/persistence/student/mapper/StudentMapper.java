package org.example.persistence.student.mapper;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.persistence.GenericMapper;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.example.persistence.auth.repository.UserJpaRepository;
import org.example.persistence.gradeInfo.entity.GradeInfo;
import org.example.persistence.gradeInfo.repository.GradeInfoJpaRepository;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentMapper implements GenericMapper<Student, StudentJpaEntity> {
    private final UserJpaRepository userRepository;
    private final GradeInfoJpaRepository gradeInfoJpaRepository;

    @Override
    public Optional<Student> toDomain(StudentJpaEntity entity) {
        if (entity == null) return Optional.empty();

        return Optional.of(new Student(
                entity.getStudentId(),
                entity.getGradeInfo().getGrade(),
                entity.getGradeInfo().getClassroom(),
                null, // todo: subject 외래키 처리
                entity.getUser().getUserId(),
                entity.getNickname(),
                entity.getEmail(),
                entity.getUser().getRole()
        ));
    }

    @Override
    public StudentJpaEntity toEntity(Student entity) {
        UserJpaEntity userEntity = userRepository.findByUserId(entity.getUserId()).orElseThrow();
        GradeInfo gradeInfo = gradeInfoJpaRepository.findByClassroomAndGrade(entity.getClassroom(), entity.getGrade()).orElseThrow();
        // todo: subject 관련 로직 추가

        return new StudentJpaEntity(
                entity.getStudentId(),
                gradeInfo,
                userEntity,
                entity.getNickname(),
                entity.getEmail()
        );
    }
}
