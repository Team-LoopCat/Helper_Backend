package org.example.global.exception;

import org.example.common.exception.GlobalBusinessException;
import org.example.common.exception.GlobalErrorCode;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice(basePackages = {"org.example"})
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalBusinessException.class)
    protected ResponseEntity<ErrorResponse> coreExceptionHandler (GlobalBusinessException e) {
        GlobalErrorCode errorCode = e.errorCode;
        ErrorResponse response = ErrorResponse.of(errorCode, errorCode.getErrorMessage());

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(errorCode.getErrorStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> validationExceptionHandler (MethodArgumentNotValidException e) {
        String description = e.getBindingResult().getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
                    .collect(Collectors.joining(" / "));
        ErrorResponse response = ErrorResponse.of(GeneralExceptionCode.BAD_REQUEST, description);

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> validationExceptionHandler (HttpMessageNotReadableException e) {
        ErrorResponse response = ErrorResponse.of(GeneralExceptionCode.BAD_REQUEST, "json 형식이 잘못된거 같습니다");

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(400));
    }
}
