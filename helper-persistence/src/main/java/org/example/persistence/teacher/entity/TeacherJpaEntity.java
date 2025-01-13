package org.example.persistence.teacher.entity;

import jakarta.persistence.*;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "teacher")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TeacherJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID teacherId;

    @OneToOne(optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "VARCHAR(5)")
    private String name;
}
