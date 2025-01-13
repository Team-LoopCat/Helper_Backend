package org.example.persistence.test.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.subject.entity.AttendJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "testInfo")
@IdClass(TestInfoId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TestInfoJpaEntity {

    @Id
    @ManyToOne(optional = false, targetEntity = AttendJpaEntity.class)
    @JoinColumn(name = "attendId", referencedColumnName = "attendId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AttendJpaEntity attend;

    @Id
    @ManyToOne(optional = false, targetEntity = TestJpaEntity.class)
    @JoinColumn(name = "testId", referencedColumnName = "testId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TestJpaEntity test;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate endDate;

}


