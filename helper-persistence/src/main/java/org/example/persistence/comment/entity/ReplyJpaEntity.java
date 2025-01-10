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
import org.example.persistence.student.entity.StudentJpaEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "reply")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
public class ReplyJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID replyId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = StudentJpaEntity.class)
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentJpaEntity student;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = CommentJpaEntity.class)
    @JoinColumn(name = "commentId", referencedColumnName = "commentId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CommentJpaEntity comment;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = true, columnDefinition = "VARCHAR(10)")
    private String mention;

    @ColumnDefault("NOW()")
    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime createdAt;
}
