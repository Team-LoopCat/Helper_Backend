package org.example.persistence.exam.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "examData")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ExamDataJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID examDataId;

    @ManyToOne(optional = false, targetEntity = ExamJpaEntity.class)
    @JoinColumn(name = "examId", referencedColumnName = "examId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ExamJpaEntity exam;

    @ManyToOne(optional = false, targetEntity = SubjectJpaEntity.class)
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectJpaEntity subject;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate date;

    @Column(nullable = false, columnDefinition = "INTEGER")
    private Integer period;

    @ColumnDefault("0")
    @Column(nullable = true, columnDefinition = "INTEGER")
    private Integer problems;

    @ColumnDefault("0")
    @Column(nullable = true, columnDefinition = "INTEGER")
    private Integer percent;

    @Column(nullable = false, columnDefinition = "VARCHAR(500)")
    private String content;
}
