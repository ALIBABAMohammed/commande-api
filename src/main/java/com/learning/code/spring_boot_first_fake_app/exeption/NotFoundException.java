package com.learning.code.spring_boot_first_fake_app.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND) //Allows us to change the status code
// we comment this annotation because we throw this class using ApiExceptionHandler
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
