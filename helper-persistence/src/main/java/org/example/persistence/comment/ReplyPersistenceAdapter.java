package org.example.persistence.comment;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.spi.QueryReplyPort;
import org.example.domain.comment.spi.vo.ReplyDataVO;
import org.example.persistence.comment.repository.ReplyJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReplyPersistenceAdapter implements QueryReplyPort {
    private final ReplyJpaRepository replyJpaRepository;

    @Override
    public List<ReplyDataVO> findAllReplyByComment(UUID commentId) {
        return replyJpaRepository.findAllWithWriterByCommentId(commentId);
    }
}
