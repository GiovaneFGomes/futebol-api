package com.giovane.futebol.service;

import com.giovane.futebol.dto.TeamsRequestDto;
import com.giovane.futebol.dto.TeamsResponseDto;
import com.giovane.futebol.exceptions.notfound.NotFoundException;
import com.giovane.futebol.mapper.TeamsMapper;
import com.giovane.futebol.model.Teams;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TeamsService {

    private final TeamsMapper mapper;

    public TeamsRequestDto save(TeamsRequestDto team) {
        mapper.insert(team);
        return team;
    }

    public void updateTeam(TeamsRequestDto teams, Integer id){
        verifyIfIdExist(id);
        teams.setId(id);
        mapper.update(teams);
    }

    public void deleteId(Integer id) {
      verifyIfIdExist(id);
      mapper.deleteById(id);
    }

    public Optional<TeamsResponseDto> select2(Integer id){
        verifyIfIdExist(id);
        return mapper.findById(id);
    }

    public List<TeamsResponseDto> select(){
        return mapper.findAll();
    }

    private void verifyIfIdExist(Integer id){
        if(mapper.findById(id).isEmpty()){
            throw new NotFoundException("Id not found"); // developerMessage
        }
    }

}
