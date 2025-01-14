package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.file.model.File;
import org.example.domain.file.service.CommandFileService;
import org.example.domain.post.dto.request.UpdatePostRequestDto;
import org.example.domain.post.dto.vo.FileDataVO;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CheckPostService;
import org.example.domain.post.service.CommandPostService;
import org.example.domain.post.service.GetPostService;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdatePostUseCase {
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final GetPostService getPostService;
    private final CheckPostService checkPostService;
    private final CommandPostService commandPostService;
    private final CommandFileService commandFileService;

    public void execute(UUID postId, UpdatePostRequestDto request) {
        User user = securityService.getCurrentUser();
        String studentId = getStudentService.getStudentByUser(user).getStudentId();
        Post post = getPostService. getPostByPostId(postId);

        checkPostService.checkIsWriter(post, studentId);

        commandFileService.deleteAllByPost(post);

        commandPostService.savePost(Post.builder()
                    .postId(postId)
                    .studentId(studentId)
                    .title(request.title())
                    .content(request.contents())
                    .photo(Optional.ofNullable(request.photo()))
                    .tag(String.join(",", request.tag()))
                    .category(request.category())
                    .createdAt(post.getCreatedAt())
                    .build()
        );

        for (FileDataVO fileDatum : request.fileData()) {
            commandFileService.saveFile(File.builder()
                    .fileId(UUID.randomUUID())
                    .postId(Optional.of(postId))
                    .testId(Optional.empty())
                    .filename(fileDatum.fileName())
                    .url(fileDatum.file())
                    .build());
        }
    }
}
