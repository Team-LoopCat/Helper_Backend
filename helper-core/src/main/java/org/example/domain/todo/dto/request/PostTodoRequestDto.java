package org.example.domain.todo.dto.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record PostTodoRequestDto(
        @NotNull String content,
        @NotNull LocalDate date
) { }
