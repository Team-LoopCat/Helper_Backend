package org.example.persistence.teacher.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.auth.entity.UserJpaEntity;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Getter
@Entity(name = "teacher")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TeacherJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID teacherId;

    @OneToOne(cascade = CascadeType.ALL, optional = false, targetEntity = UserJpaEntity.class)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserJpaEntity user;

    @Column(nullable = false, columnDefinition = "VARCHAR(5)")
    private String name;
}
