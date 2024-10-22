package org.example.domain.todo.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Todo {

    private final UUID todoID;

    private final String studentId;

    private final String content;

    private final Boolean completed;

    private final LocalDate date;
}
