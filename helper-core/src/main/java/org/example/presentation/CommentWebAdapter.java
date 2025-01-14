package org.example.presentation;

import jakarta.validation.Valid;
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
    private void createComment(@Valid @PathVariable UUID postId, @Valid @RequestBody CreateCommentRequestDto request) {
        createCommentUseCase.execute(postId, request);
    }
}
