package org.example.persistence.auth.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.auth.model.Role;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserJpaEntity {
    @Id
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String userId;

    @Column(nullable = false, columnDefinition = "varchar(225)")
    private String password;

    @Column()
    @Enumerated(EnumType.STRING)
    private Role role;

    @ColumnDefault("'DEFAULT_IMG_URL'") // todo: 기본 이미지 URL 정해지면 그걸로 바꾸기
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String profile;
}
