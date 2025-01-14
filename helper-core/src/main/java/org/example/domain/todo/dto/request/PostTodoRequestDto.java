package org.example.domain.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record PostTodoRequestDto(
        @NotBlank String content,
        @NotNull LocalDate date
) { }
