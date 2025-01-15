package org.example.domain.todo.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.student.model.Student;
import org.example.domain.todo.model.Todo;
import org.example.domain.todo.service.CheckTodoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckTodoServiceImpl implements CheckTodoService {
    @Override
    public void isOwn(Todo todo, Student student) {
        if (!todo.getStudentId().equals(student.getStudentId())) {
            throw new RuntimeException();
        }
    }
}
