package org.example.presentation;

import lombok.RequiredArgsConstructor;
import org.example.domain.comment.dto.request.CreateCommentRequestDto;
import org.example.domain.comment.usecase.CreateCommentUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class CommentWebAdapter {
    private final CreateCommentUseCase createCommentUseCase;

    @PostMapping("/create/{postId}")
    private void createComment(@PathVariable UUID postId, @RequestBody CreateCommentRequestDto request) {
        createCommentUseCase.execute(postId, request);
    }
}
