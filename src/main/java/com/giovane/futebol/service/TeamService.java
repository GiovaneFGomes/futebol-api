package com.giovane.futebol.service;

import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.dto.TeamResponseDto;
import com.giovane.futebol.exceptions.notfound.NotFoundException;
import com.giovane.futebol.mapper.TeamMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamMapper mapper;

    public TeamRequestDto save(TeamRequestDto team) {
        mapper.insert(team);
        return team;
    }

    public void update(TeamRequestDto team, Integer id){
        verifyIfIdExist(id);
        team.setId(id);
        mapper.update(team);
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
