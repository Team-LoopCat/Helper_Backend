package org.example.domain.comment.spi;

import org.example.domain.comment.model.Reply;
import org.example.domain.comment.spi.vo.ReplyDataVO;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface QueryReplyPort {

    void saveReply(Reply reply);

    List<ReplyDataVO> findAllReplyByComment(UUID commentId);

    Optional<Reply> getReplyById(UUID replyId);

    void deleteReply(Reply reply);
}
