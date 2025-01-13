package org.example.domain.todo.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.todo.model.Todo;
import org.example.domain.todo.service.CommandTodoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandTodoServiceImpl implements CommandTodoService {

    @Override
    public Todo saveTodo(Todo todo) {
        return null;
    }
}
