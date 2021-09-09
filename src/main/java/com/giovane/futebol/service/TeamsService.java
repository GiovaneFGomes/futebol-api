package com.giovane.futebol.service;

import com.giovane.futebol.exceptions.notfound.NotFoundException;
import com.giovane.futebol.mapper.TeamsMapper;
import com.giovane.futebol.model.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeamsService {

    @Autowired
    TeamsMapper mapper;

    public Teams save(Teams team) {
        mapper.insert(team);
        return team;
    }

    public void updateTeam(Teams teams, Integer id){
        verifyIfIdExist(id);
        teams.setId(id);
        mapper.update(teams);
    }

    public void deleteId(Integer id) {
      verifyIfIdExist(id);
      mapper.deleteById(id);
    }

    public Optional<Teams> select2(Integer id){
        verifyIfIdExist(id);
        return mapper.findById(id);
    }

    public List<Teams> select(){
        return mapper.findAll();
    }

    private void verifyIfIdExist(Integer id){
        if(mapper.findById(id).isEmpty()){
            throw new NotFoundException("Id not found"); // developerMessage
        }
    }

}
