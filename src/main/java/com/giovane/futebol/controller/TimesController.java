package com.giovane.futebol.controller;
import com.giovane.futebol.model.Times;
import com.giovane.futebol.service.TimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/futebol")
public class TimesController {

    @Autowired
    TimesService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/time", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Times save(@RequestBody @Valid Times times) {
        return service.save(times);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/time/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Times times, @PathVariable("id") Integer id) {
        service.updateTime(times, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/time/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.deleteId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/times")
    public List<Times> findAllTimes() {
        return service.select();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/time/{id}")
    public Times searchTimeById(@PathVariable("id") Integer id) {
        return service.select2(id);
    }

}
