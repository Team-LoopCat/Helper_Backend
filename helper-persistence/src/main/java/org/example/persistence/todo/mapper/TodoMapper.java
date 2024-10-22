package org.example.persistence.todo.mapper;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.domain.todo.model.Todo;
import org.example.persistence.GenericMapper;
import org.example.persistence.student.entity.StudentJpaEntity;
import org.example.persistence.student.repository.StudentJpaRepository;
import org.example.persistence.todo.entity.TodoJpaEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoMapper implements GenericMapper<Todo, TodoJpaEntity> {
    private final StudentJpaRepository studentJpaRepository;

    @Override
    public Optional<Todo> toDomain(Optional<TodoJpaEntity> entity) {
        if (entity.isEmpty()) return Optional.empty();

        TodoJpaEntity todoJpaEntity = entity.get();

        return Optional.of(new Todo(
                todoJpaEntity.getTodoId(),
                todoJpaEntity.getStudent().getStudentId(),
                todoJpaEntity.getContent(),
                todoJpaEntity.getCompleted(),
                todoJpaEntity.getDate()
        ));
    }

    @Override
    public TodoJpaEntity toEntity(Todo entity) {
        StudentJpaEntity studentJpaEntity = studentJpaRepository.findByStudentId
                (entity.getStudentId()).orElse(null);

        return new TodoJpaEntity(
                entity.getTodoID(),
                studentJpaEntity,
                entity.getContent(),
                entity.getCompleted(),
                entity.getDate()
        );
    }
}
