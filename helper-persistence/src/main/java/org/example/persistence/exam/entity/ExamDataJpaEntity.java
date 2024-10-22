package org.example.persistence.exam.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.subject.entity.SubjectJpaEntity;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity(name = "examData")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ExamDataJpaEntity {

    @Id
    @Column(nullable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID examDataId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = ExamJpaEntity.class)
    @JoinColumn(name = "examId", referencedColumnName = "examId")
    private ExamJpaEntity exam;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = SubjectJpaEntity.class)
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
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
