package org.example.persistence.comment.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.post.entity.PostJpaEntity;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Entity(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID commentId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = StudentJpaEntity.class)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private StudentJpaEntity student;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = PostJpaEntity.class)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private PostJpaEntity post;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ColumnDefault("NOW()")
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
}
