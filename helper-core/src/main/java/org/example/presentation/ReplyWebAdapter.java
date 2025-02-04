package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.comment.dto.request.CreateReplyRequestDto;
import org.example.domain.comment.usecase.CreateReplyUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyWebAdapter {
    private final CreateReplyUseCase createReplyUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{commentId}")
    public void createPost(@Valid @RequestBody CreateReplyRequestDto request, @PathVariable("commentId") UUID commentId) {
        createReplyUseCase.execute(request, commentId);
    }
}
