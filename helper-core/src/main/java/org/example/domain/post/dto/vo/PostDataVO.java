package org.example.domain.post.dto.vo;

import org.example.domain.post.model.Post;
import org.example.domain.post.model.PostCategory;
import org.example.domain.student.model.Student;

import java.time.LocalDateTime;
import java.util.Optional;

public record PostDataVO (
    String title,
    String contents,
    Optional<String> photo,
    String[] tag,
    PostCategory category,
    LocalDateTime createdAt,
    String writerName,
    String studentId
) {
    public static PostDataVO of(Student student, Post post) {
        return new PostDataVO(
                post.getTitle(),
                post.getContent(),
                post.getPhoto(),
                post.getTag().split(","),
                post.getCategory(),
                post.getCreatedAt(),
                student.getNickname(),
                student.getStudentId()
        );
    }
}
