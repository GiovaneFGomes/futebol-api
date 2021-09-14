package com.giovane.futebol.controller;

import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.dto.TeamResponseDto;
import com.giovane.futebol.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/soccer")
public class TeamsController {

    private final TeamService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/team", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeamRequestDto saveTeam(@RequestBody @Valid TeamRequestDto team) {
        return service.save(team);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/team/{id}")
    public void updateTeam(@RequestBody @Valid TeamRequestDto team, @PathVariable("id") Integer id) {
        service.update(team, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/team/{id}")
    public void deleteTeam(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/teams")
    public List<TeamResponseDto> findAllTeams() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/team/{id}")
    public Optional<TeamResponseDto> searchTeamById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

}
