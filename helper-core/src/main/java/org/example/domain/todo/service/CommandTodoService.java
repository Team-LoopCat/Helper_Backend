package org.example.domain.todo.service;

import org.example.domain.todo.model.Todo;

public interface CommandTodoService {

    Todo saveTodo(Todo todo);
}
