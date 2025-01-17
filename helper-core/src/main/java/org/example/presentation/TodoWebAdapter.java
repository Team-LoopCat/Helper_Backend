package org.example.presentation;

import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.todo.dto.request.PostTodoRequestDto;
import org.example.domain.todo.dto.response.PostTodoResponseDto;
import org.example.domain.todo.dto.response.ToggleTodoResponseDto;
import org.example.domain.todo.usecase.DeleteTodoUseCase;
import org.example.domain.todo.usecase.PostTodoUseCase;
import org.example.domain.todo.usecase.ToggleTodoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final DeleteTodoUseCase deleteTodoUseCase;
    private final ToggleTodoUseCase toggleTodoUseCase;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PostTodoResponseDto postTodo(@Valid @RequestBody PostTodoRequestDto request) {
        return postTodoUseCase.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{todo_id}")
    public void deleteTodo(@PathVariable("todo_id") UUID todoId) {
        deleteTodoUseCase.execute(todoId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/toggle/{todo_id}")
    public ToggleTodoResponseDto toggleTodo(@PathVariable("todo_id") UUID todoId) {
        return toggleTodoUseCase.execute(todoId);
    }
}
