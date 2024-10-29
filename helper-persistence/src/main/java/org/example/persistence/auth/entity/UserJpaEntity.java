package org.example.persistence.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.auth.model.Role;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String userId;

    @Column(nullable = false, columnDefinition = "VARCHAR(225)")
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ColumnDefault("'DEFAULT_IMG_URL'") // todo: 기본 이미지 URL 정해지면 그걸로 바꾸기
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String profile;
}
