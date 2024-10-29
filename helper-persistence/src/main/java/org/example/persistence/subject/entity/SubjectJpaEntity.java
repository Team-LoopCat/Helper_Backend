package org.example.persistence.subject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity(name = "subject")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SubjectJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID subjectId;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(20)")
    private String name;

    @ColumnDefault("false")
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean optional;
}
