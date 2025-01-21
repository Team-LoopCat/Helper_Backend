package org.example.persistence.post.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.example.domain.post.model.PostCategory;
import org.example.domain.post.spi.vo.PostListDatumVO;
import org.example.persistence.post.entity.PostJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostJpaRepository extends CrudRepository<PostJpaEntity, UUID> {

    Optional<PostJpaEntity> getPostJpaEntityByPostId(UUID postId);

    Boolean existsByPostId(UUID postId);

    @Query("SELECT " +
            "new org.example.domain.post.spi.vo.PostListDatumVO(p.postId, p.title, p.content, p.tag, count(c.post.postId)) " +
            "FROM post p LEFT OUTER JOIN comment c ON p.postId = c.post.postId " +
            "LEFT OUTER JOIN reply r ON c.commentId = r.comment.commentId " +
            "WHERE (p.title LIKE CONCAT('%', :keyword, '%') " +
            "OR p.content LIKE CONCAT('%', :keyword, '%')) " +
            "AND (:category IS NULL OR p.category = :category) " +
            "GROUP BY p.postId, p.title, p.content, p.tag " +
            "ORDER BY p.createdAt desc")
    List<PostListDatumVO> findByTitleOrContentLikeKeywordAndCategory(@Param("keyword") String keyword, @Param("category") PostCategory category);
}
