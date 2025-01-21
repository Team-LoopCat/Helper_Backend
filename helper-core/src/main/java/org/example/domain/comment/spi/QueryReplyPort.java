package org.example.domain.comment.spi;

import org.example.domain.comment.spi.vo.ReplyDataVO;

import java.util.List;
import java.util.UUID;

public interface QueryReplyPort {

    List<ReplyDataVO> findAllReplyByComment(UUID commentId);
}
