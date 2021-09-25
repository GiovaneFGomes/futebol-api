package com.giovane.futebol.mapper;

import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.dto.TeamResponseDto;
import com.giovane.futebol.model.Team;
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
    void save_team() {
        teamMapper.insert(createTeam());
        int size = teamMapper.findAll().size();
        assertEquals(1, size);
    }

    @Test
    public void list_all_teams() {
        int size = teamMapper.findAll().size();
        assertEquals(0, size);
    }

    @Test
    public void delete_team_byId() {
        teamMapper.deleteById(1);
        List<TeamResponseDto> listCliente = teamMapper.findAll();
        assertEquals(0, listCliente.size());
    }

    @Test
    public void update_team(){
        Team team = createTeam();
        team.setId(2);
        teamMapper.update(team);
         Optional<TeamResponseDto> byId = teamMapper.findById(2);
        assertEquals("Modificado", byId.isPresent());
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