package org.example.persistence.student.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.example.persistence.subject.entity.SubjectJpaEntity;


@Getter
@Entity(name = "student")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StudentJpaEntity {

    @Id
    @Column(nullable = false, unique = true, columnDefinition = "CHAR(4)")
    private String studentId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = GradeInfoJpaEntity.class)
    @JoinColumns({
            @JoinColumn(name = "grade", referencedColumnName = "grade"),
            @JoinColumn(name = "classroom", referencedColumnName = "classroom")
    })
    private GradeInfoJpaEntity gradeInfo;

    @ManyToOne(cascade = CascadeType.ALL, optional = true, targetEntity = SubjectJpaEntity.class)
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    private SubjectJpaEntity subject;

    @OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "VARCHAR(40)")
    private String nickname;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String email;
}
