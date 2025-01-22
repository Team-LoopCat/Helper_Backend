package org.example.domain.comment.spi;

import org.example.domain.comment.model.Reply;

public interface QueryReplyPort {

    void saveReply(Reply reply);
}
