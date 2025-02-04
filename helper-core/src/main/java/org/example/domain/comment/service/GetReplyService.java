package org.example.domain.comment.service;

import org.example.domain.comment.spi.vo.ReplyDataVO;
import org.example.domain.comment.model.Reply;

import java.util.List;
import java.util.UUID;

public interface GetReplyService {

    List<ReplyDataVO> getAllRepliesByComment(UUID commentId);

    Reply getReplyById(UUID replyId);
}
