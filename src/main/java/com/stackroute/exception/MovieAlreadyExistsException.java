package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class MovieAlreadyExistsException extends RuntimeException{
    public MovieAlreadyExistsException(String message){
        super(message);
    }
}
