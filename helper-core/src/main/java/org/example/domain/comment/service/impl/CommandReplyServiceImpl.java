package org.example.domain.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.model.Reply;
import org.example.domain.comment.service.CommandReplyService;
import org.example.domain.comment.spi.QueryReplyPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandReplyServiceImpl implements CommandReplyService {
    private final QueryReplyPort queryReplyPort;

    @Override
    public void createReply(Reply reply) {
        queryReplyPort.saveReply(reply);
    }

    @Override
    public void deleteReply(Reply reply) {
        queryReplyPort.deleteReply(reply);
    }
}
