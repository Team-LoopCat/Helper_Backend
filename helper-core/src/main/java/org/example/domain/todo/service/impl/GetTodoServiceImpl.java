package org.example.domain.todo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.domain.todo.exception.TodoNotFoundException;
import org.example.domain.todo.model.Todo;
import org.example.domain.todo.service.GetTodoService;
import org.example.domain.todo.spi.TodoQueryPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTodoServiceImpl implements GetTodoService {
    private final TodoQueryPort todoQueryPort;

    @Override
    public Todo getTodoById(UUID todoId) {
        return todoQueryPort.findTodoById(todoId).orElseThrow(
                () -> TodoNotFoundException.EXCEPTION
        );
    }

    @Override
    public List<Todo> getAllTodoByDateAndStudent(LocalDate date, Student student) {
        return todoQueryPort.findAllTodoByStudentId(date, student.getStudentId());
    }
}
