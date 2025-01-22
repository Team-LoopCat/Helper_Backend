package org.example.persistence.comment;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.Reply;
import org.example.domain.comment.spi.QueryReplyPort;
import org.example.persistence.comment.mapper.ReplyMapper;
import org.example.persistence.comment.repository.ReplyJpaRepository;
import org.springframework.stereotype.Component;

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
}
