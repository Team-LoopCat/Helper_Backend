package org.example.persistence.study.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.study.model.Category;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.example.persistence.subject.entity.SubjectJpaEntity;

@Getter
@Entity(name = "study")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StudyJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID studyId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = StudentJpaEntity.class)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private StudentJpaEntity student;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = SubjectJpaEntity.class)
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    private SubjectJpaEntity subject;

    @Column(nullable = false, columnDefinition = "VARCHAR(40)")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String location;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String date;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String end;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
}
