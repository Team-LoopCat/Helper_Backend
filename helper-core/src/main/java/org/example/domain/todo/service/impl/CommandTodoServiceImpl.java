package org.example.domain.todo.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.todo.model.Todo;
import org.example.domain.todo.service.CommandTodoService;
import org.example.domain.todo.spi.TodoQueryPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandTodoServiceImpl implements CommandTodoService {
    private final TodoQueryPort todoQueryPort;

    @Override
    public Todo saveTodo(Todo todo) {
        return todoQueryPort.saveTodo(todo);
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoQueryPort.deleteTodo(todo);
    }
}
