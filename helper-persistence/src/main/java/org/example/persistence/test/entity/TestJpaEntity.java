package org.example.persistence.test.entity;

import jakarta.persistence.*;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "test")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TestJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID testId;

    @ManyToOne(optional = false, targetEntity = SubjectJpaEntity.class)
    @JoinColumn(nullable = false, name = "subjectId", referencedColumnName = "subjectId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectJpaEntity subject;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(nullable = false, columnDefinition = "VARCHAR(800)")
    private String content;

    @Column(nullable = false, columnDefinition = "INTEGER")
    private Integer percent;
}
