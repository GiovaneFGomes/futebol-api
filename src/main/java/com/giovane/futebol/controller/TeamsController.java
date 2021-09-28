package com.giovane.futebol.controller;

import com.giovane.futebol.model.dto.TeamRequestDto;
import com.giovane.futebol.model.dto.TeamResponseDto;
import com.giovane.futebol.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/soccer")
public class TeamsController {

    private final TeamService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/team", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save a football team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Team was created"),
            @ApiResponse(responseCode = "400", description = "An incorrect request has been sent")
    })
    public TeamResponseDto saveTeam(@RequestBody @Valid TeamRequestDto team) {
        return service.saveTeam(team);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/team/{id}")
    @Operation(summary = "Update a football team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Team has been updated"),
            @ApiResponse(responseCode = "400", description = "An incorrect request has been sent"),
            @ApiResponse(responseCode = "404", description = "Team's ID does not exist")
    })
    public TeamResponseDto updateTeam(@RequestBody @Valid TeamRequestDto team, @PathVariable("id") Integer id) {
        return service.updateTeamById(team, id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/team/{id}")
    @Operation(summary = "Delete a football team by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The football team has been deleted"),
            @ApiResponse(responseCode = "400", description = "An incorrect request has been sent"),
            @ApiResponse(responseCode = "404", description = "Team's ID does not exist")
    })
    public void deleteTeam(@PathVariable("id") Integer id) {
        service.deleteTeamById(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/teams")
    @Operation(summary = "List all football teams")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shows all football teams"),
    })
    public List<TeamResponseDto> findAllTeams() {
        return service.findAllTeams();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/team/{id}")
    @Operation(summary = "Return a single football team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shows a single football team"),
            @ApiResponse(responseCode = "400", description = "An incorrect request has been sent"),
            @ApiResponse(responseCode = "404", description = "Team's ID does not exist")
    })
    public TeamResponseDto searchTeamById(@PathVariable("id") Integer id) {
        return service.findTeamById(id);
    }

}
