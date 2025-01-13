package org.example.domain.todo.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Todo {

    private final UUID todoId;

    private final String studentId;

    private final String content;

    private final Boolean completed;

    private final LocalDate date;
}
