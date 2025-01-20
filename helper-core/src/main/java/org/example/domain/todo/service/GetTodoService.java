package org.example.domain.todo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.example.domain.student.model.Student;
import org.example.domain.todo.model.Todo;

public interface GetTodoService {

    Todo getTodoById(UUID todoId);

    List<Todo> getAllTodoByDateAndStudent(LocalDate date, Student student);
}
