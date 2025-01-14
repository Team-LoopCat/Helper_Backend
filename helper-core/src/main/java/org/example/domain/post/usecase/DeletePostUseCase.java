package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CheckPostService;
import org.example.domain.post.service.CommandPostService;
import org.example.domain.post.service.GetPostService;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class DeletePostUseCase {
    private final SecurityService securityService;
    private final GetPostService getPostService;
    private final GetStudentService getStudentService;
    private final CommandPostService commandPostService;
    private final CheckPostService checkPostService;

    public void execute(UUID postId) {
        User currentUser = securityService.getCurrentUser();
        String studentId = getStudentService.getStudentByUser(currentUser).getStudentId();
        Post post = getPostService.getPostByPostId(postId);

        checkPostService.checkIsWriter(post, studentId);

        commandPostService.deletePost(post);
    }
}
