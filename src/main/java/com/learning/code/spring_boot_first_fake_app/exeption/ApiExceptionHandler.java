package com.learning.code.spring_boot_first_fake_app.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice //the annotation is for this class to work entire our app
//and where we handle one or more exceptions
public class ApiExceptionHandler {
    //ResponseEntity is building response to our client
    //<Object> is going to pass our custom(ApiException class)
    //handleApiRequestException takes the exception (ApiRequestException) that
    // is going to handle and build the payload (apiException) for our client
    //and send the response (ResponseEntity)
    //To throw this exception (ApiRequestException) and let spring boot to do its things by handling
    // this exception is by adding this annotation
    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(

            ApiRequestException e
    ) {

        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = NotFoundException.class)
    //this what we will use to build the response to our client
    public ResponseEntity<Object> handleApiRequestException(

            NotFoundException e
            // e is what the client for this methode passes
    ) {

        //build payload for our client
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        //send the resnponse entity
        return new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND
        );
    }
}
