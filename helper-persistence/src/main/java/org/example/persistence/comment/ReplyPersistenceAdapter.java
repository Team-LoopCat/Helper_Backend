package org.example.persistence.comment;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.Reply;
import org.example.domain.comment.spi.QueryReplyPort;
import org.example.persistence.comment.mapper.ReplyMapper;
import org.example.persistence.comment.repository.ReplyJpaRepository;
import org.springframework.stereotype.Component;
import org.example.domain.comment.spi.vo.ReplyDataVO;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReplyPersistenceAdapter implements QueryReplyPort {
    private final ReplyJpaRepository replyJpaRepository;
    private final ReplyMapper replyMapper;

    @Override
    public void saveReply(Reply reply) {
        replyJpaRepository.save(
                replyMapper.toEntity(reply)
        );
    }

    @Override
    public List<ReplyDataVO> findAllReplyByComment(UUID commentId) {
        return replyJpaRepository.findAllWithWriterByCommentId(commentId);
    }
}
