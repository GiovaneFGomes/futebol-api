package com.giovane.futebol.service;

import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.dto.TeamResponseDto;
import com.giovane.futebol.exceptions.notfound.NotFoundException;
import com.giovane.futebol.mapper.TeamMapper;
import com.giovane.futebol.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamMapper mapper;

    public TeamRequestDto save(TeamRequestDto team) {
        Team team1 = team.createTeam(team);
        Team teamSave1 = mapper.insert(team1);
        return new TeamRequestDto(teamSave1);
    }

    public void update(TeamRequestDto team, Integer id){
        mapper.findById(id).orElseThrow(() -> new NotFoundException("ID not found"));
        Team team2 = team.createTeam(team);
        mapper.update(team2);
    }

    public void deleteById(Integer id) {
        mapper.findById(id).orElseThrow(() -> new NotFoundException("ID not found"));
        mapper.deleteById(id);
    }

    public Optional<TeamResponseDto> findById(Integer id){
        mapper.findById(id).orElseThrow(() -> new NotFoundException("ID not found"));
        return mapper.findById(id);
    }

    public List<TeamResponseDto> findAll(){
        return mapper.findAll();
    }



}
