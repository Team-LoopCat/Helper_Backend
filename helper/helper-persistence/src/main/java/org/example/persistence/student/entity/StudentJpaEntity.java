package org.example.persistence.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.example.persistence.gradeInfo.entity.GradeInfo;
import org.hibernate.annotations.ColumnDefault;


@Getter
@AllArgsConstructor
@Entity(name = "student")
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

    @ColumnDefault("DEFAULT_IMG_URL") // todo: 기본 이미지 URL 정해지면 그걸로 바꾸기
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String profile;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String email;

    protected StudentJpaEntity() {}
}
