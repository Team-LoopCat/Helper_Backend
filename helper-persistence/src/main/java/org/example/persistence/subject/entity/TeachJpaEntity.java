package org.example.persistence.subject.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.teacher.entity.TeacherJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "teach")
@IdClass(TeachId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TeachJpaEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = TeacherJpaEntity.class)
    @JoinColumn(name = "teacherId", referencedColumnName = "teacherId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TeacherJpaEntity teacher;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = SubjectJpaEntity.class)
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectJpaEntity subject;
}
