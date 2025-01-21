package org.example.persistence.comment.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.example.domain.comment.spi.vo.CommentDataVO;
import org.example.persistence.comment.entity.CommentJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CommentJpaRepository extends CrudRepository<CommentJpaEntity, UUID> {

    Optional<CommentJpaEntity> findByCommentId(UUID commentId);

    @Query(value = "SELECT " +
           "NEW org.example.domain.comment.spi.vo.CommentDataVO(c.commentId, s.studentId, s.nickname, c.content, c.createdAt) " +
           "FROM student s INNER JOIN comment c ON s.studentId = c.student.studentId " +
           "WHERE c.post.postId = :postId " +
           "ORDER BY 4 desc")
    List<CommentDataVO> findAllWithWriterByPostId(@Param("postId") UUID postId);
}
