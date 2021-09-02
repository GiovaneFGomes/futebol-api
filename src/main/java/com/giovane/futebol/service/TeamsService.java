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
        Optional<Teams> byId = mapper.findById(id);
        if (byId.isPresent()){
            teams.setId(byId.get().getId());
            mapper.update(teams);
        }else{
            throw new NotFoundException("Requested team/"+id+" does not have a team");
        }
    }

    public void deleteId(Integer id) {
        Optional<Teams> byId = mapper.findById(id);
        if (byId.isPresent()) {
            mapper.deleteById(id);
        }else{
            throw new NotFoundException("Not found team");
        }
    }

    public List<Teams> select(){
        List<Teams> teams = mapper.findAll();
        return teams;
    }

    public Teams select2(Integer id){
        return mapper.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found team"));
    }

}
