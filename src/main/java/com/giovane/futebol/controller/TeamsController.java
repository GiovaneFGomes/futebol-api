package com.giovane.futebol.controller;

import com.giovane.futebol.model.Teams;
import com.giovane.futebol.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/soccer")
public class TeamsController {

    @Autowired
    TeamsService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/team", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Teams save(@RequestBody @Valid Teams teams) {
        return service.save(teams);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/team/{id}")
    public void update(@RequestBody @Valid Teams teams, @PathVariable("id") Integer id) {
        service.updateTeam(teams, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/team/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.deleteId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/teams")
    public List<Teams> findAllTimes() {
        return service.select();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/team/{id}")
    public Teams searchTeamById(@PathVariable("id") Integer id) {
        return service.select2(id);
    }

}
