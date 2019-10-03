package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(MovieAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public @ResponseBody
    ExceptionResponse MovieAlreadyExistsHandler(MovieAlreadyExistsException e, HttpServletRequest req){
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(e.getMessage());
        error.setRequestedUri(req.getRequestURI());
        return error;
    }
    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse MovieNotFoundHandler(MovieNotFoundException e,HttpServletRequest req){
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(e.getMessage());
        error.setRequestedUri(req.getRequestURI());
        return error;
    }
}
