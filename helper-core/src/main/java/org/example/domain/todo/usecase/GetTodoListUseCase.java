package org.example.domain.todo.usecase;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.common.service.SecurityService;
import org.example.domain.student.model.Student;
import org.example.domain.student.service.GetStudentService;
import org.example.domain.todo.dto.response.GetTodoListResponseDto;
import org.example.domain.todo.model.Todo;
import org.example.domain.todo.service.GetTodoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetTodoListUseCase {
    private GetTodoService getTodoService;
    private SecurityService securityService;
    private GetStudentService getStudentService;

    public GetTodoListResponseDto execute(LocalDate date) {
        Student currentStudent = getStudentService.getStudentByUser(securityService.getCurrentUser());

        List<Todo> todos = getTodoService.getAllTodoByDateAndStudent(date, currentStudent);

        return GetTodoListResponseDto.from(todos);
    }
}
