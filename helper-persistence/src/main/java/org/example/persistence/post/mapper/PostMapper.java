package org.example.persistence.post.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.post.model.Post;
import org.example.persistence.GenericMapper;
import org.example.persistence.post.entity.PostJpaEntity;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.example.persistence.student.repository.StudentJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostMapper implements GenericMapper<Post, PostJpaEntity> {
    private final StudentJpaRepository studentJpaRepository;

    @Override
    public Optional<Post> toDomain(Optional<PostJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        PostJpaEntity jpaEntity = entity.get();

        return Optional.of(new Post(
                jpaEntity.getPostId(),
                jpaEntity.getStudent().getStudentId(),
                jpaEntity.getTitle(),
                jpaEntity.getContent(),
                Optional.ofNullable(jpaEntity.getPhoto()),
                jpaEntity.getTag(),
                jpaEntity.getCategory(),
                jpaEntity.getCreatedAt()
        ));
    }

    @Override
    public PostJpaEntity toEntity(Post entity) {
        StudentJpaEntity studentJpaEntity = studentJpaRepository.findByStudentId
                (entity.getStudentId()).orElse(null);

        return new PostJpaEntity(
                entity.getPostId(),
                studentJpaEntity,
                entity.getTitle(),
                entity.getContent(),
                entity.getPhoto().orElse(null),
                entity.getTag(),
                entity.getCategory(),
                entity.getCreatedAt()
        );
    }
}
