package org.example.domain.todo.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.domain.todo.exception.errorCode.TodoErrorCode;

public class TodoNotFoundException extends GlobalBusinessException {
    public static final TodoNotFoundException EXCEPTION = new TodoNotFoundException();

    public TodoNotFoundException() { super(TodoErrorCode.TODO_NOT_FOUND); }
}
