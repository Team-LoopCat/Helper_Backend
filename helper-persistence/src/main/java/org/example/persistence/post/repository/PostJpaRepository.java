package org.example.persistence.post.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.example.domain.post.dto.vo.PostListDataVO;
import org.example.persistence.post.entity.PostJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostJpaRepository extends CrudRepository<PostJpaEntity, UUID> {

    Optional<PostJpaEntity> getPostJpaEntityByPostId(UUID postId);

    Boolean existsByPostId(UUID postId);

    @Query("SELECT p.postId, p.title, p.content, p.tag, count(c.post.postId) as commentCount " +
            "FROM post p INNER JOIN comment c ON p.postId = c.post.postId " +
            "WHERE p.title LIKE %:keyword% " +
            "OR p.content LIKE %:keyword% " +
            "GROUP BY p.postId, p.title, p.content, p.tag")
    List<PostListDataVO> searchAllByTitleOrContentLikeKeyword(@Param("keyword") String keyword);
}
