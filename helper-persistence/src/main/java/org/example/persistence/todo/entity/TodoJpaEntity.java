package org.example.persistence.todo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "todo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TodoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID todoId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = StudentJpaEntity.class)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentJpaEntity student;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String content;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean completed;

    @Column(nullable = true, columnDefinition = "DATE")
    private LocalDate date;
}
