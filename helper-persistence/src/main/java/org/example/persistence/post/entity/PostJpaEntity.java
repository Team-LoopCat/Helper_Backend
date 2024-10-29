package org.example.persistence.post.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.study.model.Category;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID postId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = StudentJpaEntity.class)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private StudentJpaEntity student;

    @Column(nullable = false, columnDefinition = "VARCHAR(40)")
    private String title;

    @Column(nullable = false, columnDefinition = "VARCHAR(1200)")
    private String content;

    @Column(nullable = true, columnDefinition = "VARCHAR(100)")
    private String photo;

    @Column(nullable = false, columnDefinition = "VARCHAR(150)")
    private String tag;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @ColumnDefault("NOW()")
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
}
