package org.example.persistence.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Getter;
import org.example.domain.student.model.Major;

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
