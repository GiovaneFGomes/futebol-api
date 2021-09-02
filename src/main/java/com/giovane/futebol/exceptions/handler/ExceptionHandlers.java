package com.giovane.futebol.exceptions.handler;

import com.giovane.futebol.exceptions.notfound.NotFoundDetails;
import com.giovane.futebol.exceptions.notfound.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlers extends Throwable{

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNotFoundException(NotFoundException e){
        NotFoundDetails notFoundDetails;
        notFoundDetails = NotFoundDetails.NotFoundDetailsBuilder.newBuilder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .details(e.getMessage())
                .developerMessage(e.getClass().getName())
                .build();
        return new ResponseEntity<>(notFoundDetails, HttpStatus.NOT_FOUND);

    }

}
