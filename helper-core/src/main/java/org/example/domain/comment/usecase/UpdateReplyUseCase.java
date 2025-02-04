package org.example.domain.comment.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.comment.dto.request.UpdateReplyRequestDto;
import org.example.domain.comment.model.Reply;
import org.example.domain.comment.service.CheckReplyService;
import org.example.domain.comment.service.CommandReplyService;
import org.example.domain.comment.service.GetReplyService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateReplyUseCase {
    private final CommandReplyService commandReplyService;
    private final GetReplyService getReplyService;
    private final CheckReplyService checkReplyService;
    private final GetStudentService getStudentService;
    private final SecurityService securityService;

    public void execute(UpdateReplyRequestDto request, UUID replyId) {
        Student student = getStudentService.getStudentByUser(securityService.getCurrentUser());
        Reply reply = getReplyService.getReplyById(replyId);

        checkReplyService.checkIsOwner(reply, student);

        commandReplyService.createReply(Reply.builder()
                    .replyId(replyId)
                    .studentId(student.getStudentId())
                    .content(request.contents())
                    .mention(Optional.ofNullable(request.mention()))
                    .createdAt(reply.getCreatedAt())
                    .build());
    }
}
