package org.example.persistence.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.student.model.Major;

@Getter
@Entity(name = "exam")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ExamJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID examId;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate start;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate end;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Major major;

    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String grade;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate deadline;
}

