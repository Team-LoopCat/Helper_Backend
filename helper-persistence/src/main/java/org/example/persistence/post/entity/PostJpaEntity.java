package org.example.persistence.post.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.post.model.PostCategory;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
public class PostJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID postId;

    @ManyToOne(optional = false, targetEntity = StudentJpaEntity.class)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    @OnDelete(action = OnDeleteAction.CASCADE)
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
    private PostCategory category;

    @ColumnDefault("NOW()")
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
}
