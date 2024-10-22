package org.example.persistence.student.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.example.persistence.gradeInfo.entity.GradeInfo;
import org.hibernate.annotations.ColumnDefault;


@Getter
@AllArgsConstructor
@Entity(name = "student")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentJpaEntity {
    @Id()
    @Column(nullable = false, unique = true, columnDefinition = "char(4)")
    private String studentId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = GradeInfo.class)
    @JoinColumns({
            @JoinColumn(name = "grade", referencedColumnName = "grade"),
            @JoinColumn(name = "classroom", referencedColumnName = "classroom")
    })
    private GradeInfo gradeInfo;

    // todo: subject 엔티티 추가시 외래키 추가할 것

    @OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "varchar(40)")
    private String nickname;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String email;
}
