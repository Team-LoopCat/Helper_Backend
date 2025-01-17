package org.example.domain.todo.service;

import org.example.domain.student.model.Student;
import org.example.domain.todo.model.Todo;

public interface CheckTodoService {

    void isOwn(Todo todo, Student student);
}
