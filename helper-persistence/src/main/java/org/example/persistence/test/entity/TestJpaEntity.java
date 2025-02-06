package org.example.persistence.test.entity;

import jakarta.persistence.*;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "test")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TestJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, columnDefinition = "BINARY(16)")
    private UUID testId;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(nullable = false, columnDefinition = "VARCHAR(800)")
    private String content;

    @Column(nullable = false, columnDefinition = "INTEGER")
    private Integer percent;
}
