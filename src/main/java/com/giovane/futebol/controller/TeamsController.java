package com.giovane.futebol.controller;

import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.dto.TeamResponseDto;
import com.giovane.futebol.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Save a football team")
    public TeamRequestDto saveTeam(@RequestBody @Valid TeamRequestDto team) {
        return service.save(team);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/team/{id}")
    @Operation(summary = "Update a football team")
    public void updateTeam(@RequestBody @Valid TeamRequestDto team, @PathVariable("id") Integer id) {
        service.update(team, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/team/{id}")
    @Operation(summary = "Delete a football team by ID")
    public void deleteTeam(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/teams")
    @Operation(summary = "List all football teams")
    public List<TeamResponseDto> findAllTeams() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/team/{id}")
    @Operation(summary = "Return a single football team")
    public Optional<TeamResponseDto> searchTeamById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

}
