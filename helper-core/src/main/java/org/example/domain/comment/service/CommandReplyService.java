package org.example.domain.comment.service;

import org.example.domain.comment.model.Reply;

public interface CommandReplyService {

    void createReply(Reply reply);

    void deleteReply(Reply reply);
}
