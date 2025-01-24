package org.example.persistence.comment.repository;

import java.util.List;
import java.util.UUID;

import org.example.domain.comment.spi.vo.ReplyDataVO;
import org.example.persistence.comment.entity.ReplyJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReplyJpaRepository extends CrudRepository<ReplyJpaEntity, UUID> {

    @Query(value = "SELECT " +
            "NEW org.example.domain.comment.spi.vo.ReplyDataVO(r.replyId, s.studentId, s.user.profile, s.nickname, r.content, r.createdAt) " +
            "FROM student s INNER JOIN reply r ON s.studentId = r.student.studentId " +
            "WHERE r.comment.commentId = :commentId " +
            "ORDER BY 4 desc")
    List<ReplyDataVO> findAllWithWriterByCommentId(@Param("commentId") UUID commentId);
}
