package com.giovane.futebol.mapper;

import com.giovane.futebol.model.dto.TeamResponseDto;
import com.giovane.futebol.model.Team;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@TestPropertySource("classpath:application-test.properties")
class TeamMapperTest {

    @Autowired
    TeamMapper teamMapper;


    @Test
    @Disabled
    void save_team() {
        teamMapper.insert(createTeam());
        int size = teamMapper.findAll().size();
        assertEquals(2, size);
    }

    @Test
    @Disabled
    void update_team_by_Id(){
        Team team = createTeam();
        teamMapper.findAll();
        teamMapper.update(team);
        Optional<TeamResponseDto>team1 = teamMapper.findById(team.getId());
        assertEquals(1,team1);
    }


    @Test
    void find_team_by_Id() {

    }


    @Test
    void team_Id_not_found() {
        assertEquals(Optional.empty(), teamMapper.findById(1));
    }

    @Test
    void list_all_teams() {
        int size = teamMapper.findAll().size();
        assertEquals(0, size);
    }

    @Test
    void delete_team_by_Id() {
        teamMapper.deleteById(1);
        List<TeamResponseDto> listCliente = teamMapper.findAll();
        assertEquals(0, listCliente.size());
    }


    private Team createTeam() {
        return Team.builder()
                .id(1)
                .name("Inter")
                .stadium("Beira-rio")
                .country("Brazil")
                .build();
    }

}