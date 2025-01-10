package org.example.domain.comment.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.comment.dto.request.CreateCommentRequestDto;
import org.example.domain.comment.model.Comment;
import org.example.domain.comment.service.CommandCommentService;
import org.example.domain.post.service.CheckPostService;
import org.example.domain.post.service.GetPostService;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateCommentUseCase {
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final CommandCommentService commandCommentService;
    private final CheckPostService checkPostService;

    public void execute(UUID postId, CreateCommentRequestDto request) {
        User user = securityService.getCurrentUser();
        String studentId = getStudentService.getStudentByUser(user).getStudentId();

        checkPostService.checkPostExists(postId);

        commandCommentService.saveComment(Comment.builder()
                    .content(request.contents())
                    .studentId(studentId)
                    .postId(postId)
                    .build()
        );
    }
}
