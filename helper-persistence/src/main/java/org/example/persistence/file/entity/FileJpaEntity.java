package org.example.persistence.file.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.persistence.post.entity.PostJpaEntity;
import org.example.persistence.test.entity.TestJpaEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Entity(name = "file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FileJpaEntity {

    @Id
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID fileId;

    @ManyToOne(cascade = CascadeType.ALL, optional = true, targetEntity = PostJpaEntity.class)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PostJpaEntity post;

    @ManyToOne(cascade = CascadeType.ALL, optional = true, targetEntity = TestJpaEntity.class)
    @JoinColumn(name = "testId", referencedColumnName = "testId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TestJpaEntity test;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String url;

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String filename;
}
