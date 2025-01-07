package org.example.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.auth.model.User;
import org.example.domain.file.model.File;
import org.example.domain.file.service.CommendFileService;
import org.example.domain.post.dto.request.CreatePostRequestDto;
import org.example.domain.post.dto.vo.FileDataVO;
import org.example.domain.post.model.Post;
import org.example.domain.post.service.CommendPostService;
import org.example.domain.student.service.GetStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreatePostUseCase {
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final CommendPostService commendPostService;
    private final CommendFileService commendFileService;

    public void execute(CreatePostRequestDto request) {
        User user = securityService.getCurrentUser();
        String studentId =  getStudentService.getStudentByUserId(user).getStudentId();

        UUID postUUID = UUID.randomUUID();
        commendPostService.savePost(Post.builder()
                .postId(postUUID)
                .studentId(studentId)
                .title(request.title())
                .content(request.contents())
                .photo(Optional.ofNullable(request.photo()))
                .tag(String.join(",", request.tag()))
                .category(request.category())
                .createdAt(LocalDateTime.now())
                .build()
        );

        for (FileDataVO fileDatum : request.fileData()) {
            commendFileService.saveFile(File.builder()
                    .fileId(UUID.randomUUID())
                    .postId(Optional.of(postUUID))
                    .testId(Optional.empty())
                    .filename(fileDatum.fileName())
                    .url(fileDatum.file())
                    .build());
        }
    }
}
