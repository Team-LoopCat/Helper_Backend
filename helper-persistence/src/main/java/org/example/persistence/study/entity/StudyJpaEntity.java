package org.example.persistence.study.entity;

import jakarta.persistence.*;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.study.model.Category;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "study")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StudyJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID studyId;

    @ManyToOne(optional = false, targetEntity = StudentJpaEntity.class)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentJpaEntity student;

    @Column(nullable = false, columnDefinition = "VARCHAR(40)")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String location;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String date;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String start;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String end;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
}
