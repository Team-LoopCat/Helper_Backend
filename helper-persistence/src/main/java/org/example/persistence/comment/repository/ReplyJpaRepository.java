package org.example.persistence.comment.repository;

import java.util.List;
import java.util.UUID;

import org.example.domain.comment.spi.vo.ReplyDataVO;
import org.example.persistence.comment.entity.ReplyJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReplyJpaRepository extends CrudRepository<ReplyJpaEntity, UUID> {

    @Query(value = "SELECT r.replyId, r.content, r.createdAt, s.studentId, s.nickname " +
            "FROM student s INNER JOIN reply r ON s.studentId = r.student.studentId " +
            "WHERE r.comment.commentId = :commentId")
    List<ReplyDataVO> findAllWithWriterByCommentId(@Param("commentId") UUID commentId);
}
