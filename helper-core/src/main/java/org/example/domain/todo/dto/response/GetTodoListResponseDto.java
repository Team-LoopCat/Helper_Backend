package org.example.domain.todo.dto.response;

import java.util.List;
import java.util.UUID;
import org.example.domain.todo.model.Todo;

public record GetTodoListResponseDto(
        List<GetTodoResponseDto> todos
) {
    public static GetTodoListResponseDto from(List<Todo> todos) {
        return new GetTodoListResponseDto(
                todos.stream().map(GetTodoResponseDto::new).toList()
        );
    }
}

record GetTodoResponseDto(
        UUID id,
        String content,
        Boolean completed
) {
    public GetTodoResponseDto(Todo todo) {
        this(
                todo.getTodoId(),
                todo.getContent(),
                todo.getCompleted()
        );
    }
}