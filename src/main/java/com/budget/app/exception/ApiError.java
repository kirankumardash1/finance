package com.budget.app.exception;

public record ApiError(String errorCode,
                       String message,
                       String example) {
}
