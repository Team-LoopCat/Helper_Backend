package org.example.domain.todo.usecase;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.todo.dto.response.ToggleTodoResponseDto;
import org.example.domain.todo.model.Todo;
import org.example.domain.todo.service.CheckTodoService;
import org.example.domain.todo.service.CommandTodoService;
import org.example.domain.todo.service.GetTodoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ToggleTodoUseCase {
    private final GetTodoService getTodoService;
    private final SecurityService securityService;
    private final GetStudentService getStudentService;
    private final CheckTodoService checkTodoService;
    private final CommandTodoService commandTodoService;

    public ToggleTodoResponseDto execute(UUID todoId) {
        Todo currentTodo = getTodoService.getTodoById(todoId);
        Student currentStudent = getStudentService.getStudentByUser(securityService.getCurrentUser());

        checkTodoService.isOwn(currentTodo, currentStudent);

        Todo savedTodo = commandTodoService.saveTodo(
                Todo.builder()
                        .todoId(currentTodo.getTodoId())
                        .date(currentTodo.getDate())
                        .content(currentTodo.getContent())
                        .studentId(currentStudent.getStudentId())
                        .completed(!currentTodo.getCompleted())
                        .build()
        );

        return new ToggleTodoResponseDto(
                savedTodo.getCompleted()
        );
    }
}
