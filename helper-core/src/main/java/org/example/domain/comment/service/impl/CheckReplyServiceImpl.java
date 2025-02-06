package org.example.domain.comment.service.impl;

import org.example.domain.comment.exception.IsNotOwnerOfReplyException;
import org.example.domain.comment.model.Reply;
import org.example.domain.comment.service.CheckReplyService;
import org.example.domain.student.model.Student;
import org.springframework.stereotype.Service;

@Service
public class CheckReplyServiceImpl implements CheckReplyService {

    @Override
    public void checkIsOwner(Reply reply, Student student) {
        if (!reply.getStudentId().equals(student.getStudentId())) {
            throw IsNotOwnerOfReplyException.EXCEPTION;
        }
    }
}
