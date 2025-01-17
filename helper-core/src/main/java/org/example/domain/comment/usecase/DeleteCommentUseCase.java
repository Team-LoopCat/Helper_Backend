package org.example.domain.comment.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.CheckCommentService;
import org.example.domain.comment.service.CommandCommentService;
import org.example.domain.comment.service.GetCommentService;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteCommentUseCase {
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final GetCommentService getCommentService;
    private final CheckCommentService checkCommentService;
    private final CommandCommentService commandCommentService;

    public void execute(UUID commentId) {
        User user = securityService.getCurrentUser();
        String studentId = getStudentService.getStudentByUser(user).getStudentId();
        Comment comment = getCommentService.getCommentByCommentId(commentId);

        checkCommentService.checkIsOwner(comment, studentId);

        commandCommentService.deleteComment(comment);
    }
}
