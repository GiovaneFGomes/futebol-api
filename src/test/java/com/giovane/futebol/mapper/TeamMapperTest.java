package com.giovane.futebol.mapper;

import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.model.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@TestPropertySource("classpath:application-test.properties")
class TeamMapperTest {

    @Autowired
    TeamMapper teamMapper;
    
    @Test
    void save_team() {
        TeamRequestDto team = TeamRequestDto.builder()
                        .id(1)
                        .name("Inter")
                        .stadium("Beira-rio")
                        .country("Brazil")
                        .build();
        teamMapper.insert(team);
        int size = teamMapper.findAll().size();
        assertEquals(1, size);

    }
}