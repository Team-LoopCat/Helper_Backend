package org.example.domain.todo.service;

import java.util.UUID;
import org.example.domain.todo.model.Todo;

public interface GetTodoService {

    Todo getTodoById(UUID todoId);
}
