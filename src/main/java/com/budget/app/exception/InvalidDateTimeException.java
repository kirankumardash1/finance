package com.budget.app.exception;

public class InvalidDateTimeException extends RuntimeException{
    public InvalidDateTimeException(String message,Throwable cause){
        super(message,cause);
    }
}
