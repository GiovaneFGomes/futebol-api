package com.giovane.futebol.service;

import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.dto.TeamResponseDto;
import com.giovane.futebol.exceptions.notfound.NotFoundException;
import com.giovane.futebol.mapper.TeamMapper;
import com.giovane.futebol.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamMapper mapper;

    public TeamResponseDto saveTeam(TeamRequestDto team) {
        Team team1 = team.createTeam(team);
        Team team2 = mapper.insert(team1);
        return new TeamResponseDto(team2);
    }

    public TeamResponseDto updateTeamById(TeamRequestDto team, Integer id){
        mapper.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        Team team1 = team.createTeam(team);
        Team team2 = mapper.update(team1);
        return new TeamResponseDto(team2);
    }

    public void deleteTeamById(Integer id) {
        mapper.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        mapper.deleteById(id);
    }

    public TeamResponseDto findTeamById(Integer id){
        Team team = mapper.findById(id)
                .orElseThrow(() -> new NotFoundException("ID not found"));
        return new TeamResponseDto(team);
    }

    public List<TeamResponseDto> findAllTeams(){
        return mapper.findAll();
    }

}
