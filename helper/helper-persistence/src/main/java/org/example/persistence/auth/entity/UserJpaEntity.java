package org.example.persistence.auth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.domain.auth.model.Role;

@Getter
@Entity(name = "user")
public class UserJpaEntity {
    @Id
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String userId;

    @Column(nullable = false, columnDefinition = "varchar(225)")
    private String password;

    @Column()
    @Enumerated(EnumType.STRING)
    private Role role;
}
