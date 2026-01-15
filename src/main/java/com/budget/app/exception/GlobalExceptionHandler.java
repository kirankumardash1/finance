package com.budget.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidDateTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleInvalidDateTime(InvalidDateTimeException ex) {
        return new ApiError(
                "INVALID_DATETIME",
                ex.getMessage(),
                "2026-01-15T10:30:00+05:30"
        );
    }
}
