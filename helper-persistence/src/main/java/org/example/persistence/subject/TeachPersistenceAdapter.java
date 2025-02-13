package org.example.persistence.subject;

import lombok.RequiredArgsConstructor;
import org.example.domain.subject.model.Subject;
import org.example.domain.subject.spi.QueryTeachPort;
import org.example.domain.teacher.model.Teacher;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.example.persistence.subject.entity.TeachId;
import org.example.persistence.subject.mapper.SubjectMapper;
import org.example.persistence.subject.repository.TeachJpaRepository;
import org.example.persistence.teacher.entity.TeacherJpaEntity;
import org.example.persistence.teacher.mapper.TeacherMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeachPersistenceAdapter implements QueryTeachPort {
    private final TeachJpaRepository teachJpaRepository;
    private final TeacherMapper teacherMapper;
    private final SubjectMapper subjectMapper;

    @Override
    public Boolean existByTeacherAndSubject(Teacher teacher, Subject subject) {
        TeacherJpaEntity teacherEntity = teacherMapper.toEntity(teacher);
        SubjectJpaEntity subjectEntity = subjectMapper.toEntity(subject);

        return teachJpaRepository.existsById(new TeachId(teacherEntity, subjectEntity));
    }
}
