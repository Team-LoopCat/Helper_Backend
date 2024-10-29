package org.example.persistence.student.mapper;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.persistence.GenericMapper;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.example.persistence.auth.repository.UserJpaRepository;
import org.example.persistence.student.entity.GradeInfoJpaEntity;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.example.persistence.student.repository.GradeInfoJpaRepository;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.example.persistence.subject.repository.SubjectJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper implements GenericMapper<Student, StudentJpaEntity> {
    private final UserJpaRepository userRepository;
    private final GradeInfoJpaRepository gradeInfoJpaRepository;
    private final SubjectJpaRepository subjectJpaRepository;

    @Override
    public Optional<Student> toDomain(Optional<StudentJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        StudentJpaEntity studentEntity = entity.get();

        return Optional.of(new Student(
                studentEntity.getStudentId(),
                studentEntity.getGradeInfo().getGrade(),
                studentEntity.getGradeInfo().getClassroom(),
                Optional.ofNullable(studentEntity.getSubject().getSubjectId()),
                studentEntity.getUser().getUserId(),
                studentEntity.getNickname(),
                studentEntity.getEmail()
        ));
    }

    @Override
    public StudentJpaEntity toEntity(Student entity) {
        UserJpaEntity userEntity = userRepository.findByUserId
                (entity.getUserId()).orElse(null);

        GradeInfoJpaEntity gradeInfoJpaEntity = gradeInfoJpaRepository.findByClassroomAndGrade
                (entity.getClassroom(), entity.getGrade()).orElse(null);

        SubjectJpaEntity subjectJpaEntity = subjectJpaRepository.findById
                (entity.getSubjectId().orElse(new UUID(0, 0))).orElse(null);

        return new StudentJpaEntity(
                entity.getStudentId(),
                gradeInfoJpaEntity,
                subjectJpaEntity,
                userEntity,
                entity.getNickname(),
                entity.getEmail()
        );
    }
}
