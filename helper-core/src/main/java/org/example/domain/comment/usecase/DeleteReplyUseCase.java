package org.example.domain.comment.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.comment.model.Reply;
import org.example.domain.comment.service.CheckReplyService;
import org.example.domain.comment.service.CommandReplyService;
import org.example.domain.comment.service.GetReplyService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteReplyUseCase {
    private final CommandReplyService commandReplyService;
    private final CheckReplyService checkReplyService;
    private final GetStudentService getStudentService;
    private final GetReplyService getReplyService;
    private final SecurityService securityService;

    public void execute(UUID replyId) {
        Student student = getStudentService.getStudentByUser(securityService.getCurrentUser());
        Reply reply = getReplyService.getReplyById(replyId);

        checkReplyService.checkIsOwner(reply, student);

        commandReplyService.deleteReply(reply);
    }
}
