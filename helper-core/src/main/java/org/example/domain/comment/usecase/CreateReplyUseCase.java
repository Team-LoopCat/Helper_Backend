package org.example.domain.comment.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.comment.dto.request.CreateReplyRequestDto;
import org.example.domain.comment.model.Reply;
import org.example.domain.comment.service.CheckCommentService;
import org.example.domain.comment.service.CommandReplyService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateReplyUseCase {
    private final CommandReplyService commandReplyService;
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final CheckCommentService checkCommentService;

    public void execute(CreateReplyRequestDto request, UUID commentId) {
        Student currentStudent = getStudentService.getStudentByUser(securityService.getCurrentUser());
        checkCommentService.checkCommentExistsByCommentId(commentId);

        commandReplyService.createReply(Reply.builder()
                .commentId(commentId)
                .content(request.contents())
                .mention(Optional.ofNullable(request.mention()))
                .studentId(currentStudent.getStudentId())
                .build()
        );
    }
}
