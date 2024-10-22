package org.example.persistence.study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import java.io.Serializable;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "member")
@IdClass(MemberId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "CHAR(4)")
    private String studentId;

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID studyId;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean isBanned;
}

@EqualsAndHashCode
@AllArgsConstructor
class MemberId implements Serializable {

    private UUID studentId;

    private UUID studyId;
}
