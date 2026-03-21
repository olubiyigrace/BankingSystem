package com.grolfbank.grolfbankusers.exception;

import com.grolfbank.grolfbankusers.util.ErrorHandler;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final long TIMESTAMP = System.currentTimeMillis();

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorHandler handleConflictException(ConflictException conflictException) {

        return new ErrorHandler(HttpStatus.CONFLICT.value(), conflictException.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler(CustomBadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorHandler handleCustomBadRequest(CustomBadRequest customBadRequest) {

        return new ErrorHandler(HttpStatus.BAD_REQUEST.value(), customBadRequest.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorHandler handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {

        return new ErrorHandler(HttpStatus.NOT_FOUND.value(), entityNotFoundException.getMessage(), TIMESTAMP);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorHandler handleInternalServerErrorException(Exception ex) {

        return new ErrorHandler(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage() , TIMESTAMP);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorHandler handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        String validationError = methodArgumentNotValidException.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage()).findFirst().orElse("Validation error ");

        return new ErrorHandler(HttpStatus.BAD_REQUEST.value(), validationError, TIMESTAMP);
    }

}