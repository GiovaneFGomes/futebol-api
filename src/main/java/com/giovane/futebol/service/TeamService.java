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

    public TeamRequestDto update(TeamRequestDto team, Integer id){
        verifyIfIdExist(id);
        Team team2 = team.createTeam(team);
        Team teamSave2 = mapper.update(team2);
        return new TeamRequestDto(teamSave2);
    }

    public void deleteById(Integer id) {
      verifyIfIdExist(id);
      mapper.deleteById(id);
    }

    public Optional<TeamResponseDto> findById(Integer id){
        verifyIfIdExist(id);
        return mapper.findById(id);
    }

    public List<TeamResponseDto> findAll(){
        return mapper.findAll();
    }

    private void verifyIfIdExist(Integer id){
        if(mapper.findById(id).isEmpty()){
            throw new NotFoundException("ID not found");
        }
    }

}
