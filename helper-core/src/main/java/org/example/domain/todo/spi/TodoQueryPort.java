package org.example.domain.todo.spi;

import org.example.domain.todo.model.Todo;

public interface TodoQueryPort {

    Todo saveTodo(Todo todo);
}
