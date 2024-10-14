package org.example.persistence.student.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "gradeInfo")
@IdClass(GradeInfoId.class)
public class GradeInfoJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String grade;

    @Id
    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String classroom;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Major major;
}
