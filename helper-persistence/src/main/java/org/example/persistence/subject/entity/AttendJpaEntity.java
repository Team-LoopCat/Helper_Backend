package org.example.persistence.subject.entity;

import jakarta.persistence.*;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.student.entity.GradeInfoJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "attend")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AttendJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID attendId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = GradeInfoJpaEntity.class)
    @JoinColumns({
            @JoinColumn(name = "grade", referencedColumnName = "grade"),
            @JoinColumn(name = "classroom", referencedColumnName = "classroom")
    })
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private GradeInfoJpaEntity gradeInfo;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = SubjectJpaEntity.class)
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectJpaEntity subject;
}
