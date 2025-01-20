package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.post.dto.request.CreatePostRequestDto;
import org.example.domain.post.dto.request.UpdatePostRequestDto;
import org.example.domain.post.dto.response.GetPostListResponseDto;
import org.example.domain.post.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostWebAdapter {
    private final CreatePostUseCase createPostUseCase;
    private final UpdatePostUseCase updatePostUseCase;
    private final DeletePostUseCase deletePostUseCase;
    private final GetPostListUseCase getPostListUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createPost(@Valid @RequestBody CreatePostRequestDto request) {
        createPostUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping("/{postId}")
    public void updatePost(@PathVariable UUID postId, @Valid @RequestBody UpdatePostRequestDto request) {
        updatePostUseCase.execute(postId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable UUID postId) {
        deletePostUseCase.execute(postId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public GetPostListResponseDto getPostList(@RequestParam("keyword") String keyword) {
        return getPostListUseCase.execute(keyword);
    }
}
