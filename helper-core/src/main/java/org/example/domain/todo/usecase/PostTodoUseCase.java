package org.example.domain.todo.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.todo.dto.request.PostTodoRequestDto;
import org.example.domain.todo.dto.response.PostTodoResponseDto;
import org.example.domain.todo.model.Todo;
import org.example.domain.todo.service.CommandTodoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostTodoUseCase {
    private final CommandTodoService commandTodoService;
    private final SecurityService securityService;
    private final GetStudentService getStudentService;

    public PostTodoResponseDto execute(PostTodoRequestDto request) {
        Student currentStudent = getStudentService.getStudentByUser(securityService.getCurrentUser());

        Todo todo = commandTodoService.saveTodo(
                Todo.builder()
                        .studentId(currentStudent.getStudentId())
                        .content(request.content())
                        .date(request.date())
                        .build()
        );

        return new PostTodoResponseDto(todo.getTodoId());
    }
}
