package com.giovane.futebol.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giovane.futebol.dto.TeamRequestDto;
import com.giovane.futebol.service.TeamService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@EnableWebMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TeamsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    TeamService teamService;

    @Test
    void save_team_201() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .id(1)
                .name("Internacional")
                .stadium("Beira-rio")
                .country("Brazil")
                .build();
        mockMvc.perform(post("/api/v1/soccer/team")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void save_team_400() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .id(1)
                .name("Internacional")
                .stadium("Beira-rio")
                .country("Brazil")
                .build();
        mockMvc.perform(post("/api/v1/soccer/team/g")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void update_team_204() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .name("Barcelona")
                .stadium("Camp Nou")
                .country("Spain")
                .build();

        Mockito.when(teamService.save(teamRequestDto)).thenReturn(teamRequestDto);
        mockMvc.perform(put("/api/v1/soccer/team/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isNoContent());
    }

    @Test
    public void update_team_400() throws Exception {
        TeamRequestDto teamRequestDto = TeamRequestDto.builder()
                .name("Barcelona")
                .stadium("Camp Nou")
                .country("Spain")
                .build();
        mockMvc.perform(put("/api/v1/soccer/team/g")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teamRequestDto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void delete_byId_204() throws Exception {
        mockMvc.perform(delete("/api/v1/soccer/team/1"))
                .andExpect(status().isNoContent());

    }

    @Test
    void delete_byId_400() throws Exception {
        mockMvc.perform(delete("/api/v1/soccer/team/g"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void find_all_200() throws Exception {
        mockMvc.perform(get("/api/v1/soccer/teams"))
                .andExpect(status().isOk());
    }

    @Test
    void find_ById_200() throws Exception {
        mockMvc.perform(get("/api/v1/soccer/team/1"))
                .andExpect(status().isOk());
    }

    @Test
    void find_ById_400() throws Exception {
        mockMvc.perform(get("/api/v1/soccer/team/g"))
                .andExpect(status().isBadRequest());
    }


}