package com.learning.code.spring_boot_first_fake_app.exeption;

// this is what we are ging to throw
public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
