package org.example.domain.todo.spi;

import java.util.Optional;
import java.util.UUID;
import org.example.domain.todo.model.Todo;

public interface TodoQueryPort {

    Todo saveTodo(Todo todo);

    Optional<Todo> findTodoById(UUID id);

    void deleteTodo(Todo todo);
}
