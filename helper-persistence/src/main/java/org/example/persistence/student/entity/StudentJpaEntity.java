package org.example.persistence.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.example.persistence.auth.entity.UserJpaEntity;


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
    private GradeInfoJpaEntity gradeInfoJpaEntity;

    // todo: subject 엔티티 추가시 외래키 추가할 것

    @OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "VARCHAR(40)")
    private String nickname;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;
}
