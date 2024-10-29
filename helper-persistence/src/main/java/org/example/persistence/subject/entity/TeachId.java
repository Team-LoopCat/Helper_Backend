package org.example.persistence.subject.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.example.persistence.teacher.entity.TeacherJpaEntity;

@EqualsAndHashCode
@AllArgsConstructor
public class TeachId implements Serializable {

    private TeacherJpaEntity teacher;

    private SubjectJpaEntity subject;
}
