package org.example.domain.todo.spi;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.example.domain.todo.model.Todo;

public interface TodoQueryPort {

    Todo saveTodo(Todo todo);

    Optional<Todo> findTodoById(UUID id);

    List<Todo> findAllTodoByDateAndStudentId(LocalDate date, String studentId);

    void deleteTodo(Todo todo);
}
