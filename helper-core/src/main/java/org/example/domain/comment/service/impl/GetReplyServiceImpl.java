package org.example.domain.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.exception.ReplyNotFoundException;
import org.example.domain.comment.model.Reply;
import org.example.domain.comment.service.GetReplyService;
import org.example.domain.comment.spi.QueryReplyPort;
import org.example.domain.comment.spi.vo.ReplyDataVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetReplyServiceImpl implements GetReplyService {
    private final QueryReplyPort queryReplyPort;

    @Override
    public List<ReplyDataVO> getAllRepliesByComment(UUID commentId) {
        return queryReplyPort.findAllReplyByComment(commentId);
    }

    @Override
    public Reply getReplyById(UUID replyId) {
        return queryReplyPort.getReplyById(replyId).orElseThrow(
                () -> ReplyNotFoundException.EXCEPTION
        );
    }
}