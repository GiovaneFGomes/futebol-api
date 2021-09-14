package com.giovane.futebol.exceptions.handler;

import com.giovane.futebol.exceptions.methodnotvalid.ErrorDetails;
import com.giovane.futebol.exceptions.notfound.NotFoundDetails;
import com.giovane.futebol.exceptions.notfound.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;
import java.util.*;

@ControllerAdvice
public class ExceptionHandlers extends Throwable{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNotFoundException(NotFoundException e){
        NotFoundDetails notFoundDetails;
        notFoundDetails = NotFoundDetails.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .title("Not found")
                .timestamp(Instant.now())
                .details(e.getMessage())
                .developerMessage("Include a valid ID. Make sure it exists.")
                .build();
        return new ResponseEntity<>(notFoundDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodNotValid(MethodArgumentNotValidException e){
        Map<String, String> error = new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(p -> error.put(p.getField(), p.getDefaultMessage()));

        ErrorDetails errorDetails;
        errorDetails = ErrorDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Method not valid")
                .timestamp(Instant.now())
                .details(error)
                .developerMessage("Error! Check the number of characters allowed.")
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
