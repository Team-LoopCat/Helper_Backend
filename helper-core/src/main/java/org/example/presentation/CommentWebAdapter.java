package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.comment.dto.request.CreateCommentRequestDto;
import org.example.domain.comment.usecase.CreateCommentUseCase;
import org.example.domain.comment.usecase.DeleteCommentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentWebAdapter {
    private final CreateCommentUseCase createCommentUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{postId}")
    private void createComment(@Valid @PathVariable UUID postId, @Valid @RequestBody CreateCommentRequestDto request) {
        createCommentUseCase.execute(postId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{commentId}")
    private void deleteComment(@Valid @PathVariable UUID commentId) {
        deleteCommentUseCase.execute(commentId);
    }
}
