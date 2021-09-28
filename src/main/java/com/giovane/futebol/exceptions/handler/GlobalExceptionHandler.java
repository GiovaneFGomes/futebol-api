package com.giovane.futebol.exceptions.handler;

import com.giovane.futebol.exceptions.details.ExceptionDetails;
import com.giovane.futebol.exceptions.details.MethodNotValidDetails;
import com.giovane.futebol.exceptions.notfound.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler extends Throwable{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNotFoundException(NotFoundException e){
        ExceptionDetails exceptionDetails;
        exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .title("Not found")
                .timestamp(Instant.now())
                .details(e.getMessage())
                .developerMessage("Include a valid ID. Make sure it exists.")
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodNotValid(MethodArgumentNotValidException e){
        Map<String, String> error = new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(p -> error.put(p.getField(), p.getDefaultMessage()));

        MethodNotValidDetails methodNotValidDetails;
        methodNotValidDetails = MethodNotValidDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Body contains invalid JSON")
                .timestamp(Instant.now())
                .details(error)
                .developerMessage("Error! Check the number of characters allowed.")
                .build();
        return new ResponseEntity<>(methodNotValidDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerBadRequest(Exception e, WebRequest request){
        ExceptionDetails exceptionDetails;
        exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad request")
                .timestamp(Instant.now())
                .details("You sent a request that this server didn't understand")
                .developerMessage("Check the request")
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

}
