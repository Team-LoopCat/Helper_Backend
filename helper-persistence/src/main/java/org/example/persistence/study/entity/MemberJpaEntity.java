package org.example.persistence.study.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.student.entity.StudentJpaEntity;

@Getter
@Entity(name = "member")
@IdClass(MemberId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberJpaEntity {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = StudentJpaEntity.class)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private String studentId;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = StudyJpaEntity.class)
    @JoinColumn(name = "studyId", referencedColumnName = "studyId")
    private UUID studyId;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean isBanned;
}

