package org.example.persistence.subject.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.student.entity.GradeInfoJpaEntity;

@Getter
@Entity(name = "attend")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AttendJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID attendId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = GradeInfoJpaEntity.class)
    @JoinColumns({
            @JoinColumn(name = "grade", referencedColumnName = "grade"),
            @JoinColumn(name = "classroom", referencedColumnName = "classroom")
    })
    private GradeInfoJpaEntity gradeInfo;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = SubjectJpaEntity.class)
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    private SubjectJpaEntity subject;
}
