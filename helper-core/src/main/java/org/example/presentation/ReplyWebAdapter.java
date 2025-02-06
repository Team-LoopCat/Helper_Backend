package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.comment.dto.request.CreateReplyRequestDto;
import org.example.domain.comment.dto.request.UpdateReplyRequestDto;
import org.example.domain.comment.usecase.CreateReplyUseCase;
import org.example.domain.comment.usecase.UpdateReplyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyWebAdapter {
    private final CreateReplyUseCase createReplyUseCase;
    private final UpdateReplyUseCase updateReplyUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{commentId}")
    public void createReply(@Valid @RequestBody CreateReplyRequestDto request, @PathVariable("commentId") UUID commentId) {
        createReplyUseCase.execute(request, commentId);
    }


    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{replyId}")
    public void updateReply(@Valid @RequestBody UpdateReplyRequestDto request, @PathVariable("replyId") UUID replyId) {
        updateReplyUseCase.execute(request, replyId);
    }
}
