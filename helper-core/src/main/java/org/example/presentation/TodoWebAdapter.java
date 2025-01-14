package org.example.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.domain.todo.dto.request.PostTodoRequestDto;
import org.example.domain.todo.dto.response.PostTodoResponseDto;
import org.example.domain.todo.usecase.PostTodoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoWebAdapter {
    private final PostTodoUseCase postTodoUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PostTodoResponseDto postStudy(@Valid @RequestBody PostTodoRequestDto request) {
        return postTodoUseCase.execute(request);
    }
}
