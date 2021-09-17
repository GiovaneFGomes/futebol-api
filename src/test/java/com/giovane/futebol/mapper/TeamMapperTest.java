package com.giovane.futebol.mapper;

import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.service.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TeamMapperTest {

    @Autowired
    private TeamService teamService;

    @Test
    public void findAll_team() {
        int size = teamService.findAll().size();
        assertEquals(1, size);
    }


//    @Test
//    void save_team() {
//        TeamRequestDto teamToBeSaved = createTeam();
//        this.teamMapper.insert(teamToBeSaved);
//    }

//    @Test
//    void update() {
//    }
//
//    @Test
//    void findAll() {
//    }
//
//    @Test
//    void findById() {
//    }
//
//    @Test
//    void deleteById() {
//    }

    private TeamRequestDto createTeam(){
        return TeamRequestDto.builder()
                .id(1)
                .name("Internacional")
                .stadium("Beira-rio")
                .country("Brazil")
                .build();
    }

}