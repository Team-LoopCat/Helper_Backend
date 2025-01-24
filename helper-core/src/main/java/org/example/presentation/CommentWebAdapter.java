package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.comment.dto.request.CreateCommentRequestDto;
import org.example.domain.comment.dto.request.UpdateCommentRequestDto;
import org.example.domain.comment.usecase.CreateCommentUseCase;
import org.example.domain.comment.usecase.DeleteCommentUseCase;
import org.example.domain.comment.usecase.UpdateCommentUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentWebAdapter {
    private final CreateCommentUseCase createCommentUseCase;
    private final UpdateCommentUseCase updateCommentUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{postId}")
    private void createComment(@PathVariable UUID postId, @Valid @RequestBody CreateCommentRequestDto request) {
        createCommentUseCase.execute(postId, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{commentId}")
    private void updateComment(@PathVariable UUID commentId, @Valid @RequestBody UpdateCommentRequestDto request) {
        updateCommentUseCase.execute(commentId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{commentId}")
    private void deleteComment(@PathVariable UUID commentId) {
        deleteCommentUseCase.execute(commentId);
    }
}
