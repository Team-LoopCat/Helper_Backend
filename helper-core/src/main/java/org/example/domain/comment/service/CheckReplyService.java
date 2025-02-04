package org.example.domain.comment.service;

import org.example.domain.comment.model.Reply;
import org.example.domain.student.model.Student;

public interface CheckReplyService {

    void checkIsOwner(Reply reply, Student student);
}
