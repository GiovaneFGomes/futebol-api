package com.giovane.futebol.controller;

import com.giovane.futebol.model.Times;
import com.giovane.futebol.service.TimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/futebol")
public class TimesController {

    @Autowired
    TimesService service;

    //@ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/time", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody Times times){
        try {
            service.save(times);
            return ResponseEntity.status(HttpStatus.CREATED).body(times);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro inesperado");
        }

    }

    @PutMapping(path = "/time/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Times times){
        try {
            service.update(times);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(times);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro inesperado");
        }
    }

    @DeleteMapping(path = "/time/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer timeId){
        try {
            service.delete(timeId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro inesperado");
        }
    }


    @GetMapping(path = "/time")
    public ResponseEntity<?> select(){
        try {
            List<Times> times = service.select();
            return ResponseEntity.status(HttpStatus.OK).body(times);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro inesperado");
        }
    }




}
