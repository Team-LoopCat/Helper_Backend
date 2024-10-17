package org.example.persistence.gradeInfo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.domain.student.model.Major;

@Getter
@Entity(name = "gradeInfo")
@IdClass(GradeInfoId.class)
public class GradeInfo {
    @Id()
    @Column(nullable = false, columnDefinition = "char(1)")
    private String grade;

    @Id()
    @Column(nullable = false, columnDefinition = "char(1)")
    private String classroom;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Major major;
}
