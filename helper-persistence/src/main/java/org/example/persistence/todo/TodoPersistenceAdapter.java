package org.example.persistence.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.domain.todo.model.Todo;
import org.example.domain.todo.spi.TodoQueryPort;
import org.example.persistence.todo.mapper.TodoMapper;
import org.example.persistence.todo.repository.TodoJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoPersistenceAdapter implements TodoQueryPort {
    private final TodoJpaRepository todoJpaRepository;
    private final TodoMapper todoMapper;

    @Override
    public Todo saveTodo(Todo todo) {
        return todoMapper.toDomain(
                Optional.of(todoJpaRepository.save(
                        todoMapper.toEntity(todo)
                ))
        ).get();
    }

    @Override
    public Optional<Todo> findTodoById(UUID id) {
        return todoMapper.toDomain(
                todoJpaRepository.findById(id)
        );
    }

    @Override
    public List<Todo> findAllTodoByDateAndStudentId(LocalDate date, String studentId) {
        return todoJpaRepository.findAllByDateAndStudentStudentId(date, studentId).stream().map(
                (entity) -> todoMapper.toDomain(
                        Optional.of(entity)
                ).get()
        ).toList();
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoJpaRepository.delete(
                todoMapper.toEntity(todo)
        );
    }
}
